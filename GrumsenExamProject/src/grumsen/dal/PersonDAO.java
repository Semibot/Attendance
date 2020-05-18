package grumsen.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import grumsen.be.Person;
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
public class PersonDAO{
    private DBConnector dbConnect = new DBConnector();
    
    public Person createPerson(int id, Person p) throws SQLException{
        try(Connection conn = dbConnect.getConnection()){
            String sql = "INSERT INTO Person(name) VALUES(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, p.getName());
            
            int createdRows = pstmt.executeUpdate();
            
            if(createdRows == 0){
                throw new SQLException("Creating a person failed, no rows created.");
            }
            
            try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    p.setId((int)generatedKeys.getLong(1));
                }else {
                    throw new SQLException("Creating a person failed, no ID obtained");
                }
            }
        }
        return p;
    }
    
    public List<Person> getAllPeople(){
        List<Person> people = new ArrayList();
        try(Connection conn = dbConnect.getConnection()){
            String sql = "SELECT * FROM Person";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Person p = new Person(id, name);
                people.add(p);
            }
        }catch (SQLServerException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return people;
    }
}