package grumsen.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import grumsen.be.Customer;
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
public class CustomerDAO{
    private DBConnector dbConnect = new DBConnector();
    
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
    
    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList();
        try(Connection conn = dbConnect.getConnection()){
            String sql = "SELECT * FROM Customer";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int ids = rs.getInt("id");
                String name = rs.getString("name");
                int projectId = rs.getInt("projectId");
                Customer c = new Customer(ids, name, projectId);
                customers.add(c);
            }
        }catch (SQLServerException ex){
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex){
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
}