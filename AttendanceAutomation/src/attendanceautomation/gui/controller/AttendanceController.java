package attendanceautomation.gui.controller;

import attendanceautomation.be.Presence;
import attendanceautomation.be.Student;
import attendanceautomation.gui.model.AAModel;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * A class that creates the attendance view.
 *
 * @author Daniel
 */
public class AttendanceController implements Initializable{
    @FXML private Label attendanceLbl;
    @FXML private Label attendanceSubmitLbl;
    @FXML private JFXDatePicker attendanceDatePicker;
    @FXML private ToggleGroup attendanceTG1;
    @FXML private JFXComboBox attendanceComboBox;
    private LoginPageController parent;
    private String myText;
    private AAModel aam;
    private Presence presence;
    
    @FXML
    private void handleSubmitButtonAction(ActionEvent e) throws SQLException, IOException{
        RadioButton selectedRadioButton = (RadioButton)attendanceTG1.getSelectedToggle();
        String toggleGroupValue = selectedRadioButton.getText();
        
        Presence p = new Presence(0,0,
                Date.valueOf(attendanceDatePicker.getValue()),
                presence.setIsPresent(toggleGroupValue));
        aam.createPresence(p);
        
        Stage attendanceListWindow = new Stage();
        attendanceListWindow.initModality(Modality.NONE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AttendanceList.fxml"));
        Parent root = loader.load();
        AttendanceStudentListController alc = loader.getController();
        alc.setParentWindowController(this);
        
        Scene scene = new Scene(root);
        attendanceListWindow.setTitle("Student Attendance List Overview");
        attendanceListWindow.setScene(scene);
        attendanceListWindow.showAndWait();
    }
    
    private void createComboBoxItems(){
        ObservableList<Student> sList =
                FXCollections.observableArrayList(
                aam.getAllStudents());
        attendanceComboBox.getItems().addAll(sList);
        attendanceComboBox.setPromptText("Select a student");
    }
    
    public void setText(String s){
        myText = s;
        fillLabel();
    }
    
    @FXML
    private void fillLabel(){
        attendanceLbl.setText("Welcome " +myText);
    }
    
    private void setCurrentDateDatePicker(){
        final Callback<DatePicker, DateCell>
                dayCellFactory = new Callback<DatePicker, DateCell>(){
            @Override
            public DateCell call(final DatePicker datePicker){
                return new DateCell(){
                    @Override
                    public void updateItem(LocalDate item, boolean empty){
                        super.updateItem(item, empty);
                        if(item.isBefore(attendanceDatePicker.getValue().minusDays(0))){
                            setDisable(true);
                            setStyle("-fx-background-color: #EEEEEE;");
                        }
                        if(item.isAfter(attendanceDatePicker.getValue().plusDays(0))){
                            setDisable(true);
                            setStyle("-fx-background-color: #EEEEEE;");
                        }
                    }
                };
            }
        };
        attendanceDatePicker.setDayCellFactory(dayCellFactory);
    }
    
    public void setParentWindowController(LoginPageController parent){
        this.parent = parent;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        setCurrentDateDatePicker();
        attendanceDatePicker.setValue(LocalDate.now());
        createComboBoxItems();
    }
}