import java.sql.*;

public class Q3 {
  public static void main(String[] args) throws SQLException {
    
    Connection connection = null;
    ResultSet resultSet = null;
    ResultSetMetaData resultSetMetaData = null;
    Statement statement = null;

    try {
     
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak", "root", "");
    
      statement = connection.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM employee");
      resultSetMetaData = resultSet.getMetaData();        

      for(int i=1; i<=resultSetMetaData.getColumnCount(); i++) {
        System.out.println("\n[ Column (" + i + ") Information ]");
        System.out.println("Name: " + resultSetMetaData.getColumnName(i));
        System.out.println("Label: " + resultSetMetaData.getColumnLabel(i)); 
        
        System.out.println("Type: " + resultSetMetaData.getColumnTypeName(i));
        
        System.out.println("Display Size: " + resultSetMetaData.getColumnDisplaySize(i));
        System.out.println("Is Auto Increment: " + resultSetMetaData.isAutoIncrement(i)); 
        
      }
    
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
