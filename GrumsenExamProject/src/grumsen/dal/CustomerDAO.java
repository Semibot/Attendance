package grumsen.dal;

import grumsen.be.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */
public class CustomerDAO{
    DBConnector dbConnect = new DBConnector();
    
    public Customer createCustomer(int id, Customer c) throws SQLException{
        try(Connection conn = dbConnect.getConnection()){
            String sql = "INSERT INTO Customer(name, projectId) VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, c.getName());
            pstmt.setInt(2, c.getProjectId());
            
            int createdRows = pstmt.executeUpdate();
            
            if(createdRows == 0){
                throw new SQLException("Creating a customer failed, no rows created.");
            }
            
            try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    c.setId((int)generatedKeys.getLong(1));
                }else {
                    throw new SQLException("Creating a customer failed, no ID obtained");
                }
            }
        }
        return c;
    }
}