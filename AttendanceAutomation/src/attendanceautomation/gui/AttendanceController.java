package attendanceautomation.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author DKE
 */
public class AttendanceController implements Initializable{
    
    @FXML private JFXComboBox nameComboBox;
    @FXML private JFXDatePicker datepicker;
    @FXML private JFXPasswordField passwordField;
    @FXML private JFXButton submitBtn;
    @FXML private Label submitLabel;
    
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
        nameComboBox.setPromptText("Enter name");
        datepicker.setPromptText("Select a date");
        passwordField.setPromptText("Enter paassword");
    }
}