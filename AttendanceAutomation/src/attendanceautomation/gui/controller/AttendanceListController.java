package attendanceautomation.gui.controller;

import attendanceautomation.gui.model.AAModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author Daniel
 */
public class AttendanceListController implements Initializable{
    private AttendanceController parent;
    private AAModel aam;
    
    public AttendanceListController(){
        aam = new AAModel();
    }
    
    public void setParentWindowController(AttendanceController parent){
        this.parent = parent;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        aam.populateTableView();
    }
}