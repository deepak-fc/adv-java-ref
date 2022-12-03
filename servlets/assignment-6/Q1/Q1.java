import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Q1 extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
  
    Date dateAndTime = new Date();
    int currentHour = dateAndTime.getHours();
    String greeting = "";
    
    if(currentHour >= 0 && currentHour < 12) {
      greeting = "Good Morning";  
    }
    else if (currentHour >= 12 && currentHour < 17) {
      greeting = "Good Afternoon";
    }
    else if (currentHour >= 17 && currentHour < 20) {
      greeting = "Good Evening";
    }
    else {
      greeting = "Good Night";
    }
    
    out.write("<h1>" + greeting + ", " + request.getParameter("name") + "!</h1>");    
    out.write("<h2>Current Server Date and Time: " + dateAndTime.toString() + "</h2>");
  
    out.close();
  }
}

