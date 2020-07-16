package grumsen.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import grumsen.be.RegularUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class RegularUserDAO{
    private DBConnector dbConnect = new DBConnector();
    
    public RegularUser createRegularUser(int userId, RegularUser ru) throws SQLException{
        try(Connection conn = dbConnect.getConnection()){
            String sql = "INSERT INTO RegularUser(name, projectId) VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, ru.getName());
            pstmt.setInt(2, ru.getProjectId());
            
            int createdRows = pstmt.executeUpdate();
            
            if(createdRows == 0){
                throw new SQLException("Creating a regular user failed, no rows created.");
            }
            
            try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    ru.setUserId((int)generatedKeys.getLong(1));
                }else {
                    throw new SQLException("Creating a regular user failed, no ID obtained");
                }
            }
        }
        return ru;
    }
    
    public List<RegularUser> getAllRegularUsers(){
        List<RegularUser> regUsers = new ArrayList();
        try(Connection conn = dbConnect.getConnection()){
            String sql = "SELECT * FROM RegularUser";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("userId");
                String name = rs.getString("name");
                int projectId = rs.getInt("projectId");
                RegularUser ru = new RegularUser(id, name, projectId);
                regUsers.add(ru);
            }
        }catch (SQLServerException ex){
            Logger.getLogger(RegularUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex){
            Logger.getLogger(RegularUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return regUsers;
    }
}