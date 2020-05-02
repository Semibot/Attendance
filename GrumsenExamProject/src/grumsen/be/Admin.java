package grumsen.be;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Daniel
 */
public class Admin extends Person{
    private final IntegerProperty projectId;
    private final DoubleProperty hourlyPrice;
    
    public Admin(int id, String name, String role, int projectId, double hourlyPrice){
        super(id, name, role);
        this.projectId = new SimpleIntegerProperty(projectId);
        this.hourlyPrice = new SimpleDoubleProperty(hourlyPrice);
    }
    
    public double getHourlyPrice(){
        return hourlyPrice.get();
    }
    
    public void setHourlyPrice(double value){
        hourlyPrice.set(value);
    }
    
    public DoubleProperty hourlyPriceProperty(){
        return hourlyPrice;
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