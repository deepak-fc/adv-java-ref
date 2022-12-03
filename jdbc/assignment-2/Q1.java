import java.sql.*;
import java.util.*;

public class Q1 {
  public static void main (String[] args) {
    
    Scanner scanner = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
      
    try {
      
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak", "root", "");
    
      System.out.println("\n[ MENU ]");
      System.out.println("1) Insert");
      System.out.println("2) Delete");
      
      scanner = new Scanner(System.in);
      int option = scanner.nextInt();
      
      int empId;
      String empName;
      float empSalary;
      
      String query = "";
      
      switch(option) {
        case 1:
          System.out.println("[ INSERT ACTION ]");
          
          while(true) {
            System.out.print("Enter employee id: ");
            empId = scanner.nextInt();
            
            if(empId < 0) {
              System.out.println("> Invalid ID. Please enter a positive value.");
            }
            else
              break;
          }
          
          while(true) {
            System.out.print("Enter employee name: ");
            empName = scanner.nextLine();
              
            if(!isStringValid(empName)) {
              System.out.println("> Invalid name. Please enter again.");
            }
            else
              break;
          }
          
          while(true) {
            System.out.print("Enter employee salary: ");
            empSalary = scanner.nextFloat();
            
            if(empSalary < 0) {
              System.out.println("> Invalid amount. Please enter 0 or a positive value.");
            }
            else
              break;
          }
          
          query = "INSERT INTO employee VALUES(?,?,?)";
          preparedStatement = connection.prepareStatement(query);
          preparedStatement.setInt(1, empId);
          preparedStatement.setString(2, empName);
          preparedStatement.setFloat(3, empSalary);
          
          System.out.println("[ INSERT ACTION ]");
          System.out.println("\nNumber of rows affected: " + preparedStatement.executeUpdate());
          
          break;
        
        case 2:
          break;
        default:
          System.out.println("[ Invalid Option ]");
      }
    }
    
    catch (Exception e) {
      System.out.println(e);
    }
    
    finally {
    }
  }
  
  public static boolean isStringValid(String s) {
    if(s.isEmpty() || s == null || containsDigit(s))
      return false;
    else
      return true;
  }
  
  public static boolean containsDigit(String s) {
    for(char c: s.toCharArray()) {
      if(Character.isDigit(c))
        return true;
    }
    return false;
  }
}
