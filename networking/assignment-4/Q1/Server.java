import java.net.*;

public class Server {
  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    Socket socket = null;
  
    try {
      serverSocket = new ServerSocket(6666);
      socket = serverSocket.accept();
    }
    
    catch(Exception e) {
    }
    
     finally {
      try {
        serverSocket.close();
        socket.close();
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}
