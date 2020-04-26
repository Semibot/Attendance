package grumsen.gui.model;

import grumsen.be.Admin;
import grumsen.be.Customer;
import grumsen.be.Person;
import grumsen.be.User;
import grumsen.bll.GrumsenLogic;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class GrumsenModel{
    
    public Person createPerson(Person p) throws SQLException{
        GrumsenLogic persongl = new GrumsenLogic();
        return persongl.createPerson(p);
    }
    
    public Admin createAdmin(Admin a) throws SQLException{
        GrumsenLogic admingl = new GrumsenLogic();
        return admingl.createAdmin(a);
    }
    
    public Customer createCustomer(Customer c) throws SQLException{
        GrumsenLogic customergl = new GrumsenLogic();
        return customergl.createCustomer(c);
    }
    
    public User createUser(User u) throws SQLException{
        GrumsenLogic usergl = new GrumsenLogic();
        return usergl.createUser(u);
    }
}