package grumsen.be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Daniel
 */
public class Admin extends Person{
    private final IntegerProperty projectId;
    
    public Admin(int id, String name, int projectId){
        super(id, name);
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