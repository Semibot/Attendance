package attendanceautomation.be;

import java.sql.Date;

/**
 *
 * @author DKE
 */
public class Teacher{
    private int id;
    private String name;
    private Date date;
    
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