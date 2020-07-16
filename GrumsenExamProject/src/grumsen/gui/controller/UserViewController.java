package grumsen.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import grumsen.be.Admin;
import grumsen.be.RegularUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * 
 * @author Daniel
 */
public class UserViewController{
    private MainViewController parent;
    @FXML private ToggleGroup tgUser;
    @FXML private JFXRadioButton regularUserRB;
    @FXML private JFXRadioButton adminRB;
    @FXML private JFXTextField userTextfield;
    @FXML private JFXButton saveUserBtn;
    @FXML private JFXButton cancelUserBtn;
    
    @FXML
    private void handleSaveUserBtn(ActionEvent e){
        if(!userTextfield.getText().isEmpty()){
            if(regularUserRB.isSelected()){
                RegularUser ru = new RegularUser(0,
                     userTextfield.getText(), 0);
                parent.addRegularUser(ru);
                
            }else if(adminRB.isSelected()){
                Admin a = new Admin(0,
                     userTextfield.getText(), 0);
                parent.addAdmin(a);
            }
        }
        Stage sp = (Stage)saveUserBtn.getScene().getWindow();
        sp.close();
    }
    
    @FXML
    private void handleCancelUserBtn(ActionEvent e){
        Stage cp = (Stage)cancelUserBtn.getScene().getWindow();
        cp.close();
    }
    
    public void setParentWindowController(MainViewController parent){
        this.parent = parent;
    }
}