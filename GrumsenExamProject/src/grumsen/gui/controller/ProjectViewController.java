package grumsen.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import grumsen.be.Admin;
import grumsen.be.Customer;
import grumsen.be.Project;
import grumsen.be.RegularUser;
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
    @FXML private JFXComboBox userProjectCB;
    @FXML private JFXComboBox customerProjectCB;
    @FXML private JFXTextField priceProjectField;
    @FXML private JFXButton cancelProjectBtn;
    @FXML private JFXButton saveProjectBtn;
    private GrumsenModel gm;
    
    public ProjectViewController(){
        gm = new GrumsenModel();
    }
    
    @FXML
    private void handleSaveProjectBtn(ActionEvent e) throws ParseException{
        if(!nameProjectField.getText().isEmpty()){
            if(trueProjectRB.isSelected()){
                Project p = new Project(0,
                    nameProjectField.getText(),
                    Boolean.parseBoolean(trueProjectRB.getText()),
                    Integer.parseInt(priceProjectField.getText()),
                    getUserId(), getCustomerId());
                parent.addProject(p);
            }else if(falseProjectRB.isSelected()){
                Project p = new Project(0,
                    nameProjectField.getText(),
                    Boolean.parseBoolean(falseProjectRB.getText()),
                    Integer.parseInt(priceProjectField.getText()),
                    getUserId(), getCustomerId());
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
    
    public int getUserId(){
        List<Admin> aList = gm.getAllAdmins();
        List<RegularUser> ruList = gm.getAllRegularUsers();
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        String name = String.valueOf(userProjectCB.getValue());
        
        for(Admin a : aList){
            map.put(a.getUserId(), a.getName());
            Integer key = a.getUserId();
            String value = a.getName();
            if(value.equals(name)){
                return key;
            }
        }
        
        for(RegularUser ru : ruList){
            map2.put(ru.getUserId(), ru.getName());
            Integer key = ru.getUserId();
            String value = ru.getName();
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
    
    private void createUserCBItems(){
        ObservableList<Admin> aList =
                FXCollections.observableArrayList(
                        gm.getAllAdmins());
        userProjectCB.getItems().addAll(aList);
        
        ObservableList<RegularUser> ruList =
                FXCollections.observableArrayList(
                        gm.getAllRegularUsers());
        userProjectCB.getItems().addAll(ruList);
    }
    
    public void setParentWindowController(MainViewController parent){
        this.parent = parent;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        createUserCBItems();
        createCustomerCBItems();
    }
}