package attendanceautomation.be;

import java.sql.Date;

/**
 *
 * @author DKE
 */
public class Student{
    private int id;
    private String name;
    private Date date;
    
    public Student(int id, String name, Date date){
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
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
}