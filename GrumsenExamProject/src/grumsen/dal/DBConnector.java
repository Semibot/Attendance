package grumsen.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;

/**
 *
 * @author Daniel
 */
public class DBConnector{
    SQLServerDataSource ds = new SQLServerDataSource();
    
    public DBConnector(){
        ds.setDatabaseName("GrumsenExamProject");
        ds.setUser("CS2018B_3");
        ds.setPassword("CS2018B_3");
        ds.setPortNumber(1433);
        ds.setServerName("10.176.111.31");
    }
    
    public Connection getConnection() throws SQLServerException{
        return ds.getConnection();
    }
}