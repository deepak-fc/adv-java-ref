import java.sql.*;

public class Q1 {
  public static void main(String[] args) throws SQLException {
    
    Connection connection = null;
    ResultSet resultSet = null;
    DatabaseMetaData dbMetaData = null;
    
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak", "root", "");
      dbMetaData = connection.getMetaData();
      
      System.out.println("\n[ DATABASE METADATA ]");
      System.out.println("JDBC driver name : " + dbMetaData.getDriverName());
      System.out.println("JDBC driver version: " + dbMetaData.getDriverVersion());
      System.out.println("Database product name: " + dbMetaData.getDatabaseProductName()); 
      System.out.println("Database product Version: " + dbMetaData.getDatabaseProductVersion() + "\n");  
    
      resultSet = dbMetaData.getTables(null, null, null, new String[] {"TABLE"});  
      System.out.println("\n[ LIST TABLES ]");
      
      while(resultSet.next()) {
        System.out.println(resultSet.getString(1));
      }
      System.out.println();
    }
    
    catch(Exception e) {
      System.out.println(e);
    }
    
    finally {
      if(connection != null) {
        connection.close();
      }
    }
  }
}
