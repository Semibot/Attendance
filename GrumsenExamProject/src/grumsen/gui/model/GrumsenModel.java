package grumsen.gui.model;

import grumsen.be.Admin;
import grumsen.be.Customer;
import grumsen.be.Project;
import grumsen.be.User;
import grumsen.bll.GrumsenLogic;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class GrumsenModel{
    
    public Admin createAdmin(Admin a) throws SQLException{
        GrumsenLogic admingl = new GrumsenLogic();
        return admingl.createAdmin(a);
    }
    
    public List<Admin> getAllAdmins(){
        GrumsenLogic admingl = new GrumsenLogic();
        return admingl.getAllAdmins();
    }
    
    public Customer createCustomer(Customer c) throws SQLException{
        GrumsenLogic customergl = new GrumsenLogic();
        return customergl.createCustomer(c);
    }
    
    public List<Customer> getAllCustomers(){
        GrumsenLogic customergl = new GrumsenLogic();
        return customergl.getAllCustomers();
    }
    
    public User createUser(User u) throws SQLException{
        GrumsenLogic usergl = new GrumsenLogic();
        return usergl.createUser(u);
    }
    
    public List<User> getAllUsers(){
        GrumsenLogic usergl = new GrumsenLogic();
        return usergl.getAllUsers();
    }
    
    public Project createProject(Project p) throws SQLException{
        GrumsenLogic projectgl = new GrumsenLogic();
        return projectgl.createProject(p);
    }
    
    public List<Project> getAllProjects(){
        GrumsenLogic pgl = new GrumsenLogic();
        return pgl.getAllProjects();
    }
}