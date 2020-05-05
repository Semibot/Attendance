package grumsen.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import grumsen.be.Customer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * 
 * @author Daniel
 */
public class CustomerViewController implements Initializable{
    private MainViewController parent;
    @FXML private JFXTextField customerTextField;
    @FXML private JFXButton saveCustomerBtn;
    @FXML private JFXButton cancelCustomerBtn;
    
    @FXML
    private void handleSaveCustomerBtn(ActionEvent e){
        String customerName = customerTextField.getText();
        
        Customer c = new Customer(0, customerName,
                0);
        parent.addCustomer(c);
        
        Stage sc = (Stage)saveCustomerBtn.getScene().getWindow();
        sc.close();
    }
    
    @FXML
    private void handleCancelCustomerBtn(ActionEvent e){
        Stage cc = (Stage)cancelCustomerBtn.getScene().getWindow();
        cc.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }
    
    public void setParentWindowController(MainViewController parent){
        this.parent = parent;
    }
}