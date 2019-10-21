package attendanceautomation.gui;

import attendanceautomation.be.Student;
import attendanceautomation.bll.AALogic;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author DKE
 */
public class AttendanceController implements Initializable{
    @FXML private JFXComboBox<Student> nameComboBox;
    @FXML private JFXPasswordField passwordField;
    @FXML private Label submitLabel;
    @FXML private JFXButton submitBtn;
    @FXML private ImageView imageView;
    private AALogic bll;
    
    public AttendanceController(){
        bll = new AALogic();
    }
    
    private void createComboBoxItems(){
        ObservableList<Student> studentComboBoxList =
                FXCollections.observableArrayList(
                bll.getAllStudents());
        nameComboBox.getItems().addAll(studentComboBoxList);
    }
    
    @FXML
    private void submitBtnAction(ActionEvent e){
        /*Student username = nameComboBox.getValue();
        String password = passwordField.getText();
        if(username.equals("Daniel") && password.equals("Edwards")){
            System.out.println("Welcome");
        }else {
            System.out.println("Wrong password");
        }*/
        if(nameComboBox.getValue() != null || passwordField.getText() != null){
            submitLabel.setText(nameComboBox.getValue()+
                    "\n attended classes.");
        }else {
            submitLabel.setText("Please enter name and password.");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try{
            createComboBoxItems();
            
            Path dir = FileSystems.getDefault().getPath("./src/images/Attendance.png");
            Image image = new Image(dir.toUri().toURL().toExternalForm());
            imageView.setImage(image);
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }
    }
}