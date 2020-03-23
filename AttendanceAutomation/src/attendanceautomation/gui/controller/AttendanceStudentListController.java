package attendanceautomation.gui.controller;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Daniel
 */
public class AttendanceStudentListController implements Initializable{
    private final ObservableList listOverviewStudent = FXCollections.observableArrayList();
    @FXML private JFXListView<String> studentListOverview;
    private AttendanceController parent;
    
    public void setParentWindowController(AttendanceController parent){
        this.parent = parent;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        
    }
}