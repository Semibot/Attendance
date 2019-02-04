package attendanceautomation.gui;

import attendanceautomation.be.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author DKE
 */
public class NewScoWindowController implements Initializable{
    private AttendanceController parent;
    @FXML
    private TableView scoTableView;
    @FXML
    private TableColumn scoColFirstName;
    @FXML
    private TableColumn scoColLastName;
    @FXML
    private Button scoAttendBtn;
    @FXML
    private Label scoAttendLbl;
    
    public void setParentWindowController(AttendanceController parent){
        this.parent = parent;
    }
    
    @FXML
    private void addStudentsSCO(){
        scoColFirstName.setCellValueFactory(new PropertyValueFactory<Student, String>("scoColFirstName"));
        scoColLastName.setCellValueFactory(new PropertyValueFactory<Student, String>("scoColLastName"));
    }
    
    @FXML
    private void handleAttendBtn(ActionEvent e){
        System.out.println("You clicked me again!");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }
}