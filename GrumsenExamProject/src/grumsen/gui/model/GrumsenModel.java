package grumsen.gui.model;

import grumsen.be.Admin;
import grumsen.be.User;
import grumsen.bll.GrumsenLogic;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class GrumsenModel{
    
    public User createUser(User u) throws SQLException{
        GrumsenLogic usergl = new GrumsenLogic();
        return usergl.createUser(u);
    }
    
    public Admin createAdmin(Admin a) throws SQLException{
        GrumsenLogic admingl = new GrumsenLogic();
        return admingl.createAdmin(a);
    }
}