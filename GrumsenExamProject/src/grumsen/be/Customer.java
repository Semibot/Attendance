package grumsen.be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Daniel
 */
public class Customer{
    private final IntegerProperty id;
    private final StringProperty name;
    private final IntegerProperty projectId;
    
    public Customer(int id, String name, int projectId){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.projectId = new SimpleIntegerProperty(projectId);
    }
    
    public int getProjectId(){
        return projectId.get();
    }
    
    public void setProjectId(int value){
        projectId.set(value);
    }
    
    public IntegerProperty projectIdProperty(){
        return projectId;
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
    
    @Override
    public String toString(){
        return getName();
    }
}