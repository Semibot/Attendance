package grumsen.be;

import java.sql.Time;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Daniel
 */
public class Project{
    private final IntegerProperty id;
    private final StringProperty name;
    private final BooleanProperty invoiceable;
    private final ObjectProperty<Time> logHours;
    private final StringProperty notes;
    private final IntegerProperty userId;
    private final IntegerProperty customerId;
    
    public Project(int id, String name,
           boolean invoiceable, Time logHours,
           String notes, int userId, int customerId){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.invoiceable = new SimpleBooleanProperty(invoiceable);
        this.logHours = new SimpleObjectProperty<>(logHours);
        this.notes = new SimpleStringProperty(notes);
        this.userId = new SimpleIntegerProperty(userId);
        this.customerId = new SimpleIntegerProperty(customerId);
    }
    
    public int getCustomerId(){
        return customerId.get();
    }
    
    public void setCustomerId(int value){
        customerId.set(value);
    }
    
    public IntegerProperty customerIdProperty(){
        return customerId;
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
    
    public String getNotes(){
        return notes.get();
    }
    
    public void setNotes(String value){
        notes.set(value);
    }
    
    public StringProperty notesProperty(){
        return notes;
    }
    
    public Time getLogHours(){
        return logHours.get();
    }
    
    public void setLogHours(Time value){
        logHours.set(value);
    }
    
    public ObjectProperty<Time> logHoursProperty(){
        return logHours;
    }
    
    public boolean isInvoiceable(){
        return invoiceable.get();
    }
    
    public void setInvoiceable(boolean value){
        invoiceable.set(value);
    }
    
    public BooleanProperty invoiceableProperty(){
        return invoiceable;
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
        return "Project{" + "name=" + name + ", invoiceable=" + invoiceable + ", logHours=" + logHours + '}';
        //return name +", "+ invoiceable +", "+ logHours;
    }
}