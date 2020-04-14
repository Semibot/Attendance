package attendanceautomation.gui.model;

import attendanceautomation.be.Presence;
import attendanceautomation.be.Student;
import attendanceautomation.bll.AAPresenceLogic;
import attendanceautomation.bll.AAStudentLogic;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    
    public ObservableList<Presence> getPresenceData(){
        ObservableList<Presence> presence = FXCollections.observableArrayList();
        presence.add(new Presence(LocalDate.of(1980, Month.APRIL, 6), "Present"));
        presence.add(new Presence(LocalDate.of(1992, Month.APRIL, 5), "Absent"));
        presence.add(new Presence(LocalDate.of(1988, Month.FEBRUARY, 16), "Absent"));
        return presence;
    }
    
    public Presence createPresence(Presence p) throws SQLException{
        return aapl.createPresence(p);
    }
    
    public List<Student> getAllStudents(){
        return aasl.getAllStudents();
    }
}