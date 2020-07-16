package grumsen.be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Daniel
 */
public class RegularUser{
    private final IntegerProperty userId;
    private final StringProperty name;
    private final IntegerProperty projectId;
    
    public RegularUser(int userId, String name, int projectId){
        this.userId = new SimpleIntegerProperty(userId);
        this.name = new SimpleStringProperty(name);
        this.projectId = new SimpleIntegerProperty(projectId);
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
    
    public int getUserId(){
        return userId.get();
    }
    
    public void setUserId(int value){
        userId.set(value);
    }
    
    public IntegerProperty userIdProperty(){
        return userId;
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
    
    @Override
    public String toString(){
        return getName();
    }
}