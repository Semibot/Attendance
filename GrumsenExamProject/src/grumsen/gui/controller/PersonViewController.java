package grumsen.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import grumsen.be.Admin;
import grumsen.be.Person;
import grumsen.be.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * 
 * @author Daniel
 */
public class PersonViewController{
    private MainViewController parent;
    @FXML private ToggleGroup tgPerson;
    @FXML private JFXRadioButton personUserRB;
    @FXML private JFXRadioButton personAdminRB;
    @FXML private JFXTextField personTextfield;
    @FXML private JFXButton savePersonBtn;
    @FXML private JFXButton cancelPersonBtn;
    
    @FXML
    private void handleSavePersonBtn(ActionEvent e){
        if(!personTextfield.getText().isEmpty()){
            if(tgPerson.getSelectedToggle().equals(personUserRB)){
                Person u = new User(0,
                     personTextfield.getText(), 0);
                parent.addUser((User)u);
                
            }else if(tgPerson.getSelectedToggle().equals(personAdminRB)){
                Person a = new Admin(0,
                     personTextfield.getText(), 0);
                parent.addAdmin((Admin)a);
            }
        }
        Stage sp = (Stage)savePersonBtn.getScene().getWindow();
        sp.close();
    }
    
    @FXML
    private void handleCancelPersonBtn(ActionEvent e){
        Stage cp = (Stage)cancelPersonBtn.getScene().getWindow();
        cp.close();
    }
    
    public void setParentWindowController(MainViewController parent){
        this.parent = parent;
    }
}