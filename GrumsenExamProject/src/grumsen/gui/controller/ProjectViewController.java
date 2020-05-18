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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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
        if(tgProject.equals(trueProjectRB)){
            Project p = new Project(0,
                nameProjectField.getText(),
                trueProjectRB.getText(),
                logProjectField.getText(),
                notesProjectField.getText(),
                Integer.parseInt(priceProjectField.getText()),
                getPersonId(), getCustomerId());
            parent.addProject(p);
        }else if(tgProject.equals(falseProjectRB)){
            Project p = new Project(0,
                nameProjectField.getText(),
                falseProjectRB.getText(),
                logProjectField.getText(),
                notesProjectField.getText(),
                Integer.parseInt(priceProjectField.getText()),
                getPersonId(), getCustomerId());
            parent.addProject(p);
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
        List<Person> pList = gm.getAllPeople();
        Map<Integer, String> map = new HashMap<>();
        String name = (String)personProjectCB.getValue();
        
        for(Person p : pList){
            map.put(p.getId(), p.getName());
            Integer key = p.getId();
            String value = p.getName();
            if(value.equals(name)){
                return key;
            }
        }
        return 0;
    }
    
    public int getCustomerId(){
        List<Customer> cList = gm.getAllCustomers();
        Map<Integer, String> map = new HashMap<>();
        String customerName = (String)customerProjectCB.getValue();
        
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
    
    public void createProjectProjectView(){
        Project p = new Project(0,
            nameProjectField.getText(),
            trueProjectRB.getText(),
            logProjectField.getText(),
            notesProjectField.getText(),
            Integer.parseInt(priceProjectField.getText()),
            getPersonId(), getCustomerId());
        parent.addProject(p);
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