package attendanceautomation.dal;

import attendanceautomation.be.Student;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.Date;
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
 * @author DKE
 */
public class StudentDAO{
    SQLServerDataSource ds;
    
    public StudentDAO(){
        ds = new SQLServerDataSource();
        ds.setDatabaseName("Attend Auto");
        ds.setUser("CS2018B_3");
        ds.setPassword("CS2018B_3");
        ds.setPortNumber(1433);
        ds.setServerName("10.176.111.31");
    }
    
    //Crud Create
    public Student createStudent(int id, Student s) throws SQLException{
        
        try(Connection conn = ds.getConnection()){
            String sql = "INSERT INTO Student(name, date) VALUES(?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, s.getName());
            stmt.setDate(2, s.getDate());
            
            int createdRows = stmt.executeUpdate();
            
            if(createdRows == 0){
                throw new SQLException("Creating student failed, no rows created.");
            }
            
            try(ResultSet generatedKeys = stmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    s.setId((int)generatedKeys.getLong(1));
                }else {
                    throw new SQLException("Creating student failed, no ID obtained");
                }
            }
        }
        return s;
    }
    
    //cRud Read
    public Student getStudent(int id){
        
        try(Connection conn = ds.getConnection()){
            PreparedStatement pstmt =
                    conn.prepareStatement("SELECT * FROM Student WHERE id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int ids = rs.getInt("id");
                String name = rs.getString("name");
                Date date = rs.getDate("date");
                Student s = new Student(ids, name, date);
                return s;
            }
        }catch(SQLServerException ex){
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException ex){
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //crUd Update
    public void updateStudent(Student s) throws SQLException{
        
        try(Connection conn = ds.getConnection()){
            String sql = "UPDATE Student SET name=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, s.getName());
            stmt.setInt(2, s.getId());
            
            int updatedRows = stmt.executeUpdate();
            
            if(updatedRows == 0){
                throw new SQLException("Updating student failed, no rows updated.");
            }
            
            try(ResultSet generatedKeys = stmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    s.setId((int) generatedKeys.getLong(1));
                }else {
                    throw new SQLException("Updating a student failed, no student updated.");
                }
            }
        }
    }
    
    //cruD Delete
    public void deleteStudent(Student s) throws SQLException{
        
        try(Connection conn = ds.getConnection()){
            String sql = "DELETE FROM Student WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, s.getId());
            
            int deletedRows = stmt.executeUpdate();
            
            if(deletedRows == 0){
                throw new SQLException("Deleting a student failed, no rows deleted.");
            }
            
            try(ResultSet generatedKeys = stmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    s.setId((int) generatedKeys.getLong(1));
                }else {
                    throw new SQLException("Deleting a student failed, no ID obtained.");
                }
            }
        }
    }
    
    public List<Student> getAllStudents(){
        
        List<Student> stu = new ArrayList();
        try(Connection conn = ds.getConnection()){
            String sqlStatement = "SELECT * FROM Student";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date date = rs.getDate("date");
                Student s = new Student(id, name, date);
                stu.add(s);
            }
        }catch(SQLServerException ex){
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException ex){
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stu;
    }
}