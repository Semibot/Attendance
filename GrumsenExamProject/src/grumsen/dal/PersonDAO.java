package grumsen.dal;

import grumsen.be.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class PersonDAO{
    DBConnector dbConnect = new DBConnector();
    
    public Person createPerson(int id, Person p) throws SQLException{
        try(Connection conn = dbConnect.getConnection()){
            String sql = "INSERT INTO Person(name, role) VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getRole());
            
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
}