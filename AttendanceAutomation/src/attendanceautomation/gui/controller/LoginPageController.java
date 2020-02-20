package attendanceautomation.gui.controller;

import com.jfoenix.controls.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Class to create a login page.
 * 
 * @author Daniel
 */
public class LoginPageController implements Initializable{
    @FXML private JFXTextField userTextField;
    @FXML private JFXPasswordField passwordField;
    @FXML private ImageView imageView;
    @FXML private JFXButton loginBtn;
    
    private JFXTextField getUserTextField(){
        return userTextField;
    }
    
    @FXML
    private void handleLoginBtnAction(ActionEvent e) throws IOException{
        String username = userTextField.getText();
        String password = passwordField.getText();
        
        if(username.toLowerCase().equals("daniel") && password.toLowerCase().equals("danny")){
            Stage attendanceWindow = new Stage();
            attendanceWindow.initModality(Modality.NONE);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/attendanceautomation/gui/view/Attendance.fxml"));
            Parent root = loader.load();
            AttendanceController ac = loader.getController();
            ac.setParentWindowController(this);
            ac.setText(userTextField.getText());
            Stage lp = (Stage)loginBtn.getScene().getWindow();
            lp.close();
            
            Scene scene = new Scene(root);
            attendanceWindow.setTitle("Attendance");
            attendanceWindow.setScene(scene);
            attendanceWindow.showAndWait();
        }else {
            System.out.println("Wrong username and/or password");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try{
            Path dir = FileSystems.getDefault().getPath("./src/images/Attendance.png");
            Image image = new Image(dir.toUri().toURL().toExternalForm());
            imageView.setImage(image);
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }
    }
}