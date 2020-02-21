package attendanceautomation.gui.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.util.Callback;

/**
 * A class that creates the attendance view.
 *
 * @author Daniel
 */
public class AttendanceController implements Initializable{
    @FXML private Label attendanceLbl;
    @FXML private JFXDatePicker attendanceDatePicker;
    @FXML private JFXRadioButton attendanceRBPresent;
    @FXML private JFXRadioButton attendanceRBAbsent;
    private LoginPageController parent;
    private String myText;
    
    @FXML
    private void handleSubmitButtonAction(ActionEvent e){
        if(attendanceRBPresent.isSelected()){
            System.out.println("You are present.");
        }
        if(attendanceRBAbsent.isSelected()){
            System.out.println("You are absent.");
        }
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
    }
}