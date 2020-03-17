package attendanceautomation.be;

import java.util.Date;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Daniel
 */
public class Presence{
    private final IntegerProperty id;
    private final IntegerProperty studentId;
    private final IntegerProperty teacherId;
    private final ObjectProperty<Date> date;
    private final BooleanProperty present;
    
    public Presence(final int id, final int studentId,
            final int teacherId, final Date date,
            final boolean present){
        this.id = new SimpleIntegerProperty(id);
        this.studentId = new SimpleIntegerProperty(studentId);
        this.teacherId = new SimpleIntegerProperty(teacherId);
        this.date = new SimpleObjectProperty(date);
        this.present = new SimpleBooleanProperty(present);
    }
    
    public boolean isPresent(){
        return present.get();
    }
    
    public void setPresent(boolean value){
        present.set(value);
    }
    
    public BooleanProperty presentProperty(){
        return present;
    }
    
    public Date getDate(){
        return date.get();
    }
    
    public void setDate(Date value){
        date.set(value);
    }
    
    public ObjectProperty dateProperty(){
        return date;
    }
    
    public int getTeacherId(){
        return teacherId.get();
    }
    
    public void setTeacherId(int value){
        teacherId.set(value);
    }
    
    public IntegerProperty teacherIdProperty(){
        return teacherId;
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
    
    public int getId(){
        return id.get();
    }
    
    public void setId(int value){
        id.set(value);
    }
    
    public IntegerProperty idProperty(){
        return id;
    }
}