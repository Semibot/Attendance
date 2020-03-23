package attendanceautomation.be;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Daniel
 */
public class Presence{
    private final IntegerProperty id;
    private final IntegerProperty studentId;
    private final ObjectProperty<Date> currentDate;
    private final ObjectProperty<List<String>> isPresent;
    
    public Presence(final int id, final int studentId,
         final Date currentDate, final List<String> isPresent){
        this.id = new SimpleIntegerProperty(id);
        this.studentId = new SimpleIntegerProperty(studentId);
        this.currentDate = new SimpleObjectProperty<>(currentDate);
        this.isPresent = new SimpleObjectProperty<>(isPresent);
    }
    
    public int getId(){
        return id.get();
    }
    
    public void setId(int value){
        id.set(value);
    }
    
    public IntegerProperty idProperty(){
        return id;
    }
    
    public int getStudentId(){
        return studentId.get();
    }
    
    public void setStudentId(int value){
        studentId.set(value);
    }
    
    public IntegerProperty studentIdProperty(){
        return studentId;
    }
    
    public Date getCurrentDate(){
        return currentDate.get();
    }
    
    public void setCurrentDate(Date value){
        currentDate.set(value);
    }
    
    public ObjectProperty currentDateProperty(){
        return currentDate;
    }
    
    public List<String> getIsPresent(){
        return isPresent.get();
    }
    
    public void setIsPresent(List<String> value){
        isPresent.set(value);
    }
    
    public ObjectProperty isPresentProperty(){
        return isPresent;
    }
    
    @Override
    public String toString(){
        return currentDate+ " " +isPresent;
    }
}