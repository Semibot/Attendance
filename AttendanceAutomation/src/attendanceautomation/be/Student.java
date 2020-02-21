package attendanceautomation.be;

import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Daniel
 */
public class Student{
    private final IntegerProperty id;
    private final StringProperty name;
    private final ObjectProperty<List<String>> present;
    
    public Student(final int id, final String name,
            final List<String> present){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.present = new SimpleObjectProperty(present);
    }
    
    public List<String> getPresent(){
        return present.get();
    }
    
    public void setPresent(List<String> value){
        present.set(value);
    }
    
    public ObjectProperty presentProperty(){
        return present;
    }
    
    public final String getName(){
        return name.get();
    }
    
    public void setName(final String name){
        this.name.set(name);
    }
    
    public final int getId(){
        return id.get();
    }
    
    public void setId(final int id){
        this.id.set(id);
    }
    
    public final StringProperty nameProperty(){
        return name;
    }
    
    public final IntegerProperty idProperty(){
        return id;
    }
    
    @Override
    public String toString(){
        return name.get();
    }
}