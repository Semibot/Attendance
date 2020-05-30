package grumsen.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import grumsen.be.Admin;
import grumsen.be.Customer;
import grumsen.be.Person;
import grumsen.be.Project;
import grumsen.be.User;
import grumsen.gui.model.GrumsenModel;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author Daniel
 */
public class ProjectViewController implements Initializable{
    private MainViewController parent;
    @FXML private JFXTextField nameProjectField;
    @FXML private JFXRadioButton trueProjectRB;
    @FXML private JFXRadioButton falseProjectRB;
    @FXML private JFXComboBox personProjectCB;
    @FXML private JFXComboBox customerProjectCB;
    @FXML private JFXTextField priceProjectField;
    @FXML private JFXButton cancelProjectBtn;
    @FXML private JFXButton saveProjectBtn;
    @FXML private JFXTextField notesProjectField;
    @FXML private JFXTextField logProjectField;
    private GrumsenModel gm;
    
    public ProjectViewController(){
        gm = new GrumsenModel();
    }
    
    @FXML
    private void handleSaveProjectBtn(ActionEvent e) throws ParseException{
        if(!nameProjectField.getText().isEmpty()){
            if(trueProjectRB.getText().equalsIgnoreCase("True")){
                Project p = new Project(0,
                    nameProjectField.getText(),
                    trueProjectRB.getText(),
                    logProjectField.getText(),
                    notesProjectField.getText(),
                    Integer.parseInt(priceProjectField.getText()),
                    getPersonId(), getCustomerId());
                parent.addProject(p);
            }else if(falseProjectRB.getText().equalsIgnoreCase("False")){
                Project p = new Project(0,
                    nameProjectField.getText(),
                    falseProjectRB.getText(),
                    logProjectField.getText(),
                    notesProjectField.getText(),
                    Integer.parseInt(priceProjectField.getText()),
                    getPersonId(), getCustomerId());
                parent.addProject(p);
            }
        }
        Stage sp = (Stage)saveProjectBtn.getScene().getWindow();
        sp.close();
    }
    
    @FXML
    private void handleCancelProjectBtn(ActionEvent e){
        Stage cp = (Stage)cancelProjectBtn.getScene().getWindow();
        cp.close();
    }
    
    public int getPersonId(){
        List<Admin> aList = gm.getAllAdmins();
        List<User> uList = gm.getAllUsers();
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        String name = String.valueOf(personProjectCB.getValue());
        
        for(Admin a : aList){
            map.put(a.getId(), a.getName());
            Integer key = a.getId();
            String value = a.getName();
            if(value.equals(name)){
                return key;
            }
        }
        
        for(User u : uList){
            map.put(u.getId(), u.getName());
            Integer key = u.getId();
            String value = u.getName();
            if(value.equals(name)){
                return key;
            }
        }
        return 0;
    }
    
    public int getCustomerId(){
        List<Customer> cList = gm.getAllCustomers();
        Map<Integer, String> map = new HashMap<>();
        String customerName = String.valueOf(customerProjectCB.getValue());
        
        for(Customer c : cList){
            map.put(c.getId(), c.getName());
            Integer key = c.getId();
            String value = c.getName();
            if(value.equals(customerName)){
                return key;
            }
        }
        return 0;
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
}