package grumsen.bll;

import grumsen.be.User;
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
}