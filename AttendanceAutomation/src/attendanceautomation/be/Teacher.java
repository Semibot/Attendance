package attendanceautomation.be;

/**
 *
 * @author DKE
 */
public class Teacher{
    private int id;
    private String firstName;
    private String lastName;
    
    @Override
    public String toString(){
        return firstName + lastName;
    }
    
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}