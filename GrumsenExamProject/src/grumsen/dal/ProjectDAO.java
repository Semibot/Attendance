package grumsen.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import grumsen.be.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;

/**
 *
 * @author Daniel
 */
public class ProjectDAO{
    DBConnector dbConnect = new DBConnector();
    
    public Project createProject(int id, Project p) throws SQLException{
        try(Connection conn = dbConnect.getConnection()){
            String sql = "INSERT INTO Project(name, invoiceable,"
               +"logHours, notes, userId, customerId, hourlyPrice) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, p.getName());
            pstmt.setBoolean(2, p.isInvoiceable());
            pstmt.setTime(3, p.getLogHours());
            pstmt.setString(4, String.valueOf(p.getNotes()));
            pstmt.setInt(5, p.getUserId());
            pstmt.setInt(6, p.getCustomerId());
            pstmt.setDouble(7, p.getHourlyPrice());
            
            int createdRows = pstmt.executeUpdate();
            
            if(createdRows == 0){
                throw new SQLException("Creating a project failed, no rows created.");
            }
            
            try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    p.setId((int)generatedKeys.getLong(1));
                }else {
                    throw new SQLException("Creating a project failed, no ID obtained.");
                }
            }
        }
        return p;
    }
    
    public List<Project> getAllProjects(){
        List<Project> projects = new ArrayList();
        try(Connection conn = dbConnect.getConnection()){
            String sql = "SELECT * FROM Project";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Boolean invoiceable = rs.getBoolean("invoiceable");
                Time logHours = rs.getTime("logHours");
                Text notes = Text.class.cast(rs.getString("notes"));
                int userId = rs.getInt("userId");
                int customerId = rs.getInt("customerId");
                double hourlyPrice = rs.getDouble("hourlyPrice");
                Project p = new Project(id, name, invoiceable,
                        logHours, notes, userId, customerId, hourlyPrice);
                projects.add(p);
            }
        }catch (SQLServerException ex){
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex){
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }
}