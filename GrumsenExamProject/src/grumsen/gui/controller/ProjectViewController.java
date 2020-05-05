package grumsen.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Daniel
 */
public class ProjectViewController implements Initializable{
    private MainViewController parent;
    
    @FXML
    private void saveProject(ActionEvent e){
        
    }
    
    @FXML
    private void cancelProject(ActionEvent e){
        
    }
    
    public void setParentWindowController(MainViewController parent){
        this.parent = parent;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }
}