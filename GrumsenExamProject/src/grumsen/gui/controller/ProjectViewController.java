package grumsen.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import grumsen.be.Admin;
import grumsen.be.Customer;
import grumsen.be.User;
import grumsen.gui.model.GrumsenModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Daniel
 */
public class ProjectViewController implements Initializable{
    private MainViewController parent;
    @FXML private JFXTextField nameProjectField;
    @FXML private ToggleGroup tgProject;
    @FXML private JFXRadioButton trueProjectRB;
    @FXML private JFXRadioButton falseProjectRB;
    @FXML private JFXTextField hoursProjectField;
    @FXML private JFXComboBox personProjectCB;
    @FXML private JFXComboBox customerProjectCB;
    @FXML private JFXTextField priceProjectField;
    @FXML private JFXButton cancelProjectBtn;
    @FXML private JFXButton saveProjectBtn;
    @FXML private JFXTextField notesProjectField;
    private GrumsenModel gm;
    
    public ProjectViewController(){
        gm = new GrumsenModel();
    }
    
    private void createCustomerCBItems(){
        ObservableList<Customer> cList =
                FXCollections.observableArrayList(
                gm.getAllCustomers());
        customerProjectCB.getItems().addAll(cList);
    }
    
    private void createPersonCBItems(){
        ObservableList<Admin> aList =
                FXCollections.observableArrayList(
                        gm.getAllAdmins());
        personProjectCB.getItems().addAll(aList);
        ObservableList<User> uList =
                FXCollections.observableArrayList(
                        gm.getAllUsers());
        personProjectCB.getItems().addAll(uList);
    }
    
    public void setParentWindowController(MainViewController parent){
        this.parent = parent;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        createPersonCBItems();
        createCustomerCBItems();
    }
    
    @FXML
    private void handleCancelProjectBtn(ActionEvent e){
        
    }
    
    @FXML
    private void handleSaveProjectBtn(ActionEvent e){
        
    }
}