import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Q3 extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {  
    
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");
    
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");  
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak", "root", "");
      
      String authenticateUserQuery = "SELECT * FROM user WHERE login_name=? AND password=?";
      preparedStatement = connection.prepareStatement(authenticateUserQuery);
      preparedStatement.setString(1, name);
      preparedStatement.setString(2, password);  
      
      resultSet = preparedStatement.executeQuery();
      
      if(resultSet.next()) {
        HttpSession session = request.getSession();
        session.setAttribute("user-name", name);
        response.sendRedirect("http://localhost:8080/Welcome");
      }
      else {
        response.sendRedirect("DisplayError.html");
      }
    }
    
    catch (Exception e) {
      out.write(e.toString());
    }
    
    finally {
      try {
        connection.close();
        out.close();
      }
      catch (Exception e) {
        out.write(e.toString());
      } 
    }
  }
}
