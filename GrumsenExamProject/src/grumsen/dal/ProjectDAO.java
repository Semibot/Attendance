package grumsen.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import grumsen.be.Project;
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
public class ProjectDAO{
    private DBConnector dbConnect = new DBConnector();
    
    public Project createProject(int id, Project p) throws SQLException{
        try(Connection conn = dbConnect.getConnection()){
            String sql = "INSERT INTO Project(name, invoiceable,"
               +"logHours, notes, hourlyPrice, personId, customerId) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getInvoiceable());
            pstmt.setString(3, p.getLogHours());
            pstmt.setString(4, p.getNotes());
            pstmt.setInt(5, p.getHourlyPrice());
            pstmt.setInt(6, p.getPersonId());
            pstmt.setInt(7, p.getCustomerId());
            
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
                int ids = rs.getInt("id");
                String name = rs.getString("name");
                String invoiceable = rs.getString("invoiceable");
                String logHours = rs.getString("logHours");
                String notes = rs.getString("notes");
                int hourlyPrice = rs.getInt("hourlyPrice");
                int personId = rs.getInt("personId");
                int customerId = rs.getInt("customerId");
                Project p = new Project(ids, name, invoiceable,
                        logHours, notes, hourlyPrice, personId, customerId);
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