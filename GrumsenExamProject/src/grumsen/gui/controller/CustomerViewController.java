package grumsen.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class CustomerViewController implements Initializable{
    @FXML private JFXTextField customerTextFileld;
    @FXML private JFXButton customerSaveBtn;
    @FXML private JFXButton customerCancelBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }
}