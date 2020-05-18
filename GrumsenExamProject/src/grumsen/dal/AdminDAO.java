package grumsen.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import grumsen.be.Admin;
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
public class AdminDAO{
    private DBConnector dbConnect = new DBConnector();
    
    public Admin createAdmin(int id, Admin a) throws SQLException{
        try(Connection conn = dbConnect.getConnection()){
            String sql = "INSERT INTO AdminType(name, projectId) VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, a.getName());
            pstmt.setInt(2, a.getProjectId());
            
            int createdRows = pstmt.executeUpdate();
            
            if(createdRows == 0){
                throw new SQLException("Creating an admin failed, no rows created.");
            }
            
            try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    a.setId((int)generatedKeys.getLong(1));
                }else {
                    throw new SQLException("Creating an admin failed, no ID obtained");
                }
            }
        }
        return a;
    }
    
    public List<Admin> getAllAdmins(){
        List<Admin> admins = new ArrayList();
        try(Connection conn = dbConnect.getConnection()){
            String sql = "SELECT * FROM AdminType";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int projectId = rs.getInt("projectId");
                Admin a = new Admin(id, name, projectId);
                admins.add(a);
            }
        }catch (SQLServerException ex){
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex){
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admins;
    }
}