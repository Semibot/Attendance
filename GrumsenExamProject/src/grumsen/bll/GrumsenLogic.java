package grumsen.bll;

import grumsen.be.Admin;
import grumsen.be.User;
import grumsen.dal.AdminDAO;
import grumsen.dal.UserDAO;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class GrumsenLogic{
    
    public User createUser(User u) throws SQLException{
        UserDAO udao = new UserDAO();
        return udao.createUser(0, u);
    }
    
    public Admin createAdmin(Admin a) throws SQLException{
        AdminDAO adao = new AdminDAO();
        return adao.createAdmin(0, a);
    }
}