import java.net.*;

public class Server {
  public static void main(String[] args) {
    
    ServerSocket serverSocket = null;
    Socket socket = null;
    
    try {
      serverSocket = new ServerSocket(6666);
      System.out.println("[ Waiting for connection ]");
      socket = serverSocket.accept();
      System.out.println("[ Connected to client > " + socket.getInetAddress() + " ]");
    }
    
    catch (Exception e) {
      System.out.println(e);
    }
    
    finally {
      try {
        socket.close();
        serverSocket.close();
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}
