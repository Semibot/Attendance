package attendanceautomation.be;

import java.time.LocalDate;

/**
 *
 * @author DKE
 */
public class Student{
    private int id;
    private String name;
    private LocalDate date;
    
    public Student(int id, String name, LocalDate date){
        this.id = id;
        this.name = name;
        this.date = date;
    }
    
    @Override
    public String toString(){
        return name + date;
    }
    
    public int getId(){
        return id;
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