import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Q2 extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {  
    
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");
    
    Cookie[] cookiesFromClient = request.getCookies();
    
    int visitCounter = 0;
    Cookie cookie = new Cookie("visit-counter", "");
    String messageToClient = "";
    
    if(cookiesFromClient != null) {
      for(Cookie c: cookiesFromClient) {
        if(c.getName().equals("visit-counter")) {
          visitCounter = Integer.parseInt(c.getValue());
          break;
        }
      }
    }
    
    cookie.setValue(Integer.toString(++visitCounter));
    response.addCookie(cookie);
    
    if(visitCounter <= 1) {
      messageToClient = "<h1>Welcome, " + request.getRemoteAddr() + "</h1>";
    }
    else {
      messageToClient = "<h1>Welcome back, " + request.getRemoteAddr() + "</h1>";
    }
    out.write(messageToClient);
  }
}

