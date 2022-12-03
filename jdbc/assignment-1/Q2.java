import java.sql.*;

public class Q2 {
  public static void main(String[] args) throws SQLException {
    
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;

    try {
     
      Class.forName("com.mysql.cj.jdbc.Driver");  
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak", "root", "");
    
      statement = connection.createStatement();
      statement.execute("DROP TABLE IF EXISTS employee");
      statement.execute("CREATE TABLE employee (empid INT, empname VARCHAR(30), salary FLOAT, PRIMARY KEY (empid))");
      
      System.out.println("\n[ TABLE: (employee) CREATION SUCCESSFUL ]");
      
      System.out.println("\n[ TABLE DESCRIPTION ]");
      resultSet = statement.executeQuery("DESC employee");
      while(resultSet.next()) {
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
      }
      System.out.println("");
    
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
