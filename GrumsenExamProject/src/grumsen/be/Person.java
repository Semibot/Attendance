package grumsen.be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Daniel
 */
public class Person{
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty role;
    
    public Person(int id, String name, String role){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.role = new SimpleStringProperty(role);
    }
    
    public String getRole(){
        return role.get();
    }
    
    public void setRole(String value){
        role.set(value);
    }
    
    public StringProperty roleProperty(){
        return role;
    }
    
    public String getName(){
        return name.get();
    }
    
    public void setName(String value){
        name.set(value);
    }
    
    public StringProperty nameProperty(){
        return name;
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