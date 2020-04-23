package grumsen.gui.model;

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
}