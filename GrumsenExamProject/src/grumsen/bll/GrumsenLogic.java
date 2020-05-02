package grumsen.bll;

import grumsen.be.Admin;
import grumsen.be.Customer;
import grumsen.be.Person;
import grumsen.be.Project;
import grumsen.be.User;
import grumsen.dal.AdminDAO;
import grumsen.dal.CustomerDAO;
import grumsen.dal.PersonDAO;
import grumsen.dal.ProjectDAO;
import grumsen.dal.UserDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class GrumsenLogic{
    
    public Person createPerson(Person p) throws SQLException{
        PersonDAO pdao = new PersonDAO();
        return pdao.createPerson(0, p);
    }
    
    public Admin createAdmin(Admin a) throws SQLException{
        AdminDAO adao = new AdminDAO();
        return adao.createAdmin(0, a);
    }
    
    public Customer createCustomer(Customer c) throws SQLException{
        CustomerDAO cdao = new CustomerDAO();
        return cdao.createCustomer(0, c);
    }
    
    public User createUser(User u) throws SQLException{
        UserDAO udao = new UserDAO();
        return udao.createUser(0, u);
    }
    
    public Project createProject(Project p) throws SQLException{
        ProjectDAO pdao = new ProjectDAO();
        return pdao.createProject(0, p);
    }
    
    public List<Project> getAllProjects(){
        ProjectDAO pdao = new ProjectDAO();
        return pdao.getAllProjects();
    }
}