package grumsen.gui.model;

import grumsen.be.Admin;
import grumsen.be.Customer;
import grumsen.be.Project;
import grumsen.be.RegularUser;
import grumsen.bll.GrumsenLogic;
import grumsen.gui.controller.UserViewController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Daniel
 */
public class GrumsenModel{
    private GrumsenLogic admingl = new GrumsenLogic();
    private GrumsenLogic customergl = new GrumsenLogic();
    private GrumsenLogic regusergl = new GrumsenLogic();
    private GrumsenLogic projectgl = new GrumsenLogic();
    
    public Admin createAdmin(Admin a) throws SQLException{
        return admingl.createAdmin(a);
    }
    
    public List<Admin> getAllAdmins(){
        return admingl.getAllAdmins();
    }
    
    public Customer createCustomer(Customer c) throws SQLException{
        return customergl.createCustomer(c);
    }
    
    public List<Customer> getAllCustomers(){
        return customergl.getAllCustomers();
    }
    
    public RegularUser createRegularUser(RegularUser ru) throws SQLException{
        return regusergl.createRegularUser(ru);
    }
    
    public List<RegularUser> getAllRegularUsers(){
        return regusergl.getAllRegularUsers();
    }
    
    public Project createProject(Project p) throws SQLException{
        return projectgl.createProject(p);
    }
    
    public List<Project> getAllProjects(){
        return projectgl.getAllProjects();
    }
}