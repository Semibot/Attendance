package grumsen.bll;

import grumsen.be.Admin;
import grumsen.be.Customer;
import grumsen.be.Project;
import grumsen.be.RegularUser;
import grumsen.dal.AdminDAO;
import grumsen.dal.CustomerDAO;
import grumsen.dal.ProjectDAO;
import grumsen.dal.RegularUserDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class GrumsenLogic{
    private AdminDAO adao = new AdminDAO();
    private CustomerDAO cdao = new CustomerDAO();
    private RegularUserDAO rudao = new RegularUserDAO();
    private ProjectDAO pdao = new ProjectDAO();
    
    public Admin createAdmin(Admin a) throws SQLException{
        return adao.createAdmin(0, a);
    }
    
    public List<Admin> getAllAdmins(){
        return adao.getAllAdmins();
    }
    
    public Customer createCustomer(Customer c) throws SQLException{
        return cdao.createCustomer(0, c);
    }
    
    public List<Customer> getAllCustomers(){
        return cdao.getAllCustomers();
    }
    
    public RegularUser createRegularUser(RegularUser ru) throws SQLException{
        return rudao.createRegularUser(0, ru);
    }
    
    public List<RegularUser> getAllRegularUsers(){
        return rudao.getAllRegularUsers();
    }
    
    public Project createProject(Project p) throws SQLException{
        return pdao.createProject(0, p);
    }
    
    public List<Project> getAllProjects(){
        return pdao.getAllProjects();
    }
}