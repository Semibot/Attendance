package grumsen.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Daniel
 */
public class MainViewController implements Initializable{
    @FXML private JFXListView<String> projectListview;
    @FXML private JFXTextField textField;
    @FXML private JFXButton addBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }
    
    @FXML
    private void handleDashboardBtnAction(ActionEvent e){
        
    }
    
    @FXML
    private void handleCustomersBtnAction(ActionEvent e){
        
    }
    
    @FXML
    private void handleStatisticsBtnAction(ActionEvent e){
        
    }
    
    @FXML
    private void handleAddBtnAction(ActionEvent e){
        
    }
}