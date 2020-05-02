package grumsen.be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Daniel
 */
public class User extends Person{
    private final IntegerProperty projectId;
    
    public User(int id, String name, String role, int projectId){
        super(id, name, role);
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
}