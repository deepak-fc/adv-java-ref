import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Welcome extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");
    
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession(false);
    String name = (String) session.getAttribute("user-name");
    
    out.write("<h1>Welcome " + name + "!</h1>");
  }
}
