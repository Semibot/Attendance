package attendanceautomation.gui.model;

import attendanceautomation.be.Presence;
import attendanceautomation.be.Student;
import attendanceautomation.bll.AAPresenceLogic;
import attendanceautomation.bll.AAStudentLogic;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class AAModel{
    private AAPresenceLogic aapl;
    private AAStudentLogic aasl;
    
    public AAModel(){
        aapl = new AAPresenceLogic();
        aasl = new AAStudentLogic();
    }
    
    public Presence createPresence(Presence p) throws SQLException{
        return aapl.createPresence(p);
    }
    
    public void addPresence(Presence p){
        try{
            Presence presence = aapl.createPresence(p);
            //presences.getItems().clear();
            //listPresence.addAll(presence);
            //presences.getItems().addAll(listPresence);
        }catch (SQLException ex){
            Logger.getLogger(AAModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Student> getAllStudents(){
        return aasl.getAllStudents();
    }
}