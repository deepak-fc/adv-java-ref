import java.sql.*;

public class Jdbc {
  public static void main(String[] args) throws SQLException {
    
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    try {
      
      // Register Driver  
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      // Get Connection
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak", "root", "");
      
      // Create Statement
      statement = connection.createStatement();
      
      // Execute Query
      resultSet = statement.executeQuery("SELECT * FROM test");
      
      // Display Results
      while(resultSet.next()) {
        System.out.println(resultSet.getString(1) + "  |  " + resultSet.getString(2));
      }
    }
    
    catch(Exception e) {
      System.out.println(e);
    }
    
    finally {
      if(connection != null) {
        connection.close();
        System.out.println("\n<CONNECTION CLOSED>");
      }
      System.out.println("<EXIT>");
    }
  }
}

