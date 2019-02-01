package attendanceautomation.gui;

import attendanceautomation.be.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author DKE
 */
public class NewScoWindowController implements Initializable{
    private AttendanceController parent;
    @FXML
    private ListView<Student> scoClassList;
    @FXML
    private Button scoAttendBtn;
    @FXML
    private Label scoAttendLbl;
    
    public void setParentWindowController(AttendanceController parent){
        this.parent = parent;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
    }
}