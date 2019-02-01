package attendanceautomation.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author DKE
 */
public class NewDbosWindowController implements Initializable{
    private AttendanceController parent;
    
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