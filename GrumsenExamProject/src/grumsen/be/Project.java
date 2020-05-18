package grumsen.be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Daniel
 */
public class Project{
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty invoiceable;
    private final StringProperty logHours;
    private final StringProperty notes;
    private final IntegerProperty hourlyPrice;
    private final IntegerProperty personId;
    private final IntegerProperty customerId;
    
    public Project(int id, String name, String invoiceable,
            String logHours, String notes, int hourlyPrice,
            int personId, int customerId){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.invoiceable = new SimpleStringProperty(invoiceable);
        this.logHours = new SimpleStringProperty(logHours);
        this.notes = new SimpleStringProperty(notes);
        this.hourlyPrice = new SimpleIntegerProperty(hourlyPrice);
        this.personId = new SimpleIntegerProperty(personId);
        this.customerId = new SimpleIntegerProperty(customerId);
    }
    
    public int getHourlyPrice(){
        return hourlyPrice.get();
    }
    
    public void setHourlyPrice(int value){
        hourlyPrice.set(value);
    }
    
    public IntegerProperty hourlyPriceProperty(){
        return hourlyPrice;
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
    
    public int getPersonId(){
        return personId.get();
    }
    
    public void setPersonId(int value){
        personId.set(value);
    }
    
    public IntegerProperty personIdProperty(){
        return personId;
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
    
    public String getLogHours(){
        return logHours.get();
    }
    
    public void setLogHours(String value){
        logHours.set(value);
    }
    
    public StringProperty logHoursProperty(){
        return logHours;
    }
    
    public String getInvoiceable(){
        return invoiceable.get();
    }
    
    public void setInvoiceable(String value){
        invoiceable.set(value);
    }
    
    public StringProperty invoiceableProperty(){
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
        return getName();
    }
}