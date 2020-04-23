package grumsen.dal;

import grumsen.be.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class UserDAO{
    DBConnector dbConnect = new DBConnector();
    
    public User createUser(int id, User u) throws SQLException{
        try(Connection conn = dbConnect.getConnection()){
            String sql = "INSERT INTO User(name, projectId) VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, u.getName());
            pstmt.setInt(2, u.getProjectId());
            
            int createdRows = pstmt.executeUpdate();
            
            if(createdRows == 0){
                throw new SQLException("Creating a user failed, no rows created.");
            }
            
            try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    u.setId((int)generatedKeys.getLong(1));
                }else {
                    throw new SQLException("Creating a user failed, no ID obtained");
                }
            }
        }
        return u;
    }
}