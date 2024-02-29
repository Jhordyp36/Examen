package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:database//PADatabaseAntBot.sqlite";
    private static Connection conn = null; 

    protected  SQLDataHelper() {} 

    protected static synchronized  Connection getDBConnection() throws Exception{
        try{

            if (conn == null) {
            
                conn = DriverManager.getConnection(DBPathConnection);        
            }                                         
        }
        catch (SQLException e){
            throw e; 
        }
        return conn;                
    }
    
    protected static void closeConnection () throws Exception{
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            throw e;
        }
    }
}
