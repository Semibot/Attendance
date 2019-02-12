package attendanceautomation.be;

import java.time.LocalDate;

/**
 *
 * @author DKE
 */
public class Teacher{
    private int id;
    private String name;
    private LocalDate date;
    
    @Override
    public String toString(){
        return name + date;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public LocalDate getDate(){
        return date;
    }
    
    public void setDate(LocalDate date){
        this.date = date;
    }
}