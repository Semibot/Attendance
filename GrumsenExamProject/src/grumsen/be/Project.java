package grumsen.be;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

/**
 *
 * @author Daniel
 */
public class Project{
    private final IntegerProperty id;
    private final StringProperty name;
    private final BooleanProperty invoiceable;
    private final IntegerProperty hourlyPrice;
    private final IntegerProperty userId;
    private final IntegerProperty customerId;
    private Button button;
    
    public Project(int id, String name, Boolean invoiceable,
            int hourlyPrice, int userId, int customerId){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.invoiceable = new SimpleBooleanProperty(invoiceable);
        this.hourlyPrice = new SimpleIntegerProperty(hourlyPrice);
        this.userId = new SimpleIntegerProperty(userId);
        this.customerId = new SimpleIntegerProperty(customerId);
        this.button = new Button("button");
    }
    
    public Button getButton(){
        return button;
    }
    
    public void setButton(Button button){
        this.button = button;
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
    
    public int getUserId(){
        return userId.get();
    }
    
    public void setUserId(int value){
        userId.set(value);
    }
    
    public IntegerProperty userIdProperty(){
        return userId;
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
        return getName();
    }
}