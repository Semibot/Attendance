package attendanceautomation.gui;

import attendanceautomation.be.Student;
import attendanceautomation.bll.AALogic;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author DKE
 */
public class AttendanceController implements Initializable{
    
    @FXML private JFXComboBox<Student> nameComboBox;
    @FXML private JFXDatePicker datepicker;
    @FXML private JFXPasswordField passwordField;
    @FXML private JFXButton submitBtn;
    @FXML private Label submitLabel;
    private AALogic bll;
    
    public AttendanceController(){
        bll = new AALogic();
    }
    
    private void createComboBoxItems(){
        ObservableList<Student> studentComboBoxList =
                FXCollections.observableArrayList(
                bll.getAllStudents());
        nameComboBox.getItems().addAll(studentComboBoxList);
        nameComboBox.setPromptText("Enter name");
    }
    
    @FXML
    private void submitBtnAction(ActionEvent e){
        if(nameComboBox == null || datepicker == null || passwordField == null){
            submitLabel.setText(nameComboBox.getValue()
           +"\n attended classes on "+
                datepicker.getValue());
        }else {
            submitLabel.setText("Please enter name, date and password.");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        createComboBoxItems();
        datepicker.setPromptText("Select a date");
        passwordField.setPromptText("Enter paassword");
    }
}