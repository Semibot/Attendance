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
    
    public Person(int id, String name){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
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