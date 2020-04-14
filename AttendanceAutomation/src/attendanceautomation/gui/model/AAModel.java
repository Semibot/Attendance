package attendanceautomation.gui.model;

import attendanceautomation.be.Presence;
import attendanceautomation.be.Student;
import attendanceautomation.bll.AAPresenceLogic;
import attendanceautomation.bll.AAStudentLogic;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Daniel
 */
public class AAModel{
    private final ObservableList data = getPresenceData();
    @FXML private TableView<Presence> attendanceListTableView = new TableView();
    @FXML private TableColumn<Presence, LocalDate> dateColumn = new TableColumn();
    @FXML private TableColumn<Presence, String> attendanceColumn = new TableColumn();
    private AAPresenceLogic aapl;
    private AAStudentLogic aasl;
    
    public AAModel(){
        aapl = new AAPresenceLogic();
        aasl = new AAStudentLogic();
    }
    
    public void populateTableView(){
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("currentDate"));
        attendanceColumn.setCellValueFactory(new PropertyValueFactory<>("isPresent"));
        attendanceListTableView.setItems(data);
    }
    
    private ObservableList getPresenceData(){
        List list = new ArrayList();
        list.add(new Presence(LocalDate.of(1980, Month.APRIL, 6), "Present"));
        list.add(new Presence(LocalDate.of(1992, Month.APRIL, 5), "Absent"));
        
        ObservableList data = FXCollections.observableArrayList(list);
        return data;
    }
    
    public Presence createPresence(Presence p) throws SQLException{
        return aapl.createPresence(p);
    }
    
    public List<Student> getAllStudents(){
        return aasl.getAllStudents();
    }
}