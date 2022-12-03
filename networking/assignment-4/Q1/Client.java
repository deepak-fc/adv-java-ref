import java.net.*;

public class Client {
  public static void main(String[] args) {
    Socket socket = null;
  
    try {
      socket = new Socket("localhost", 6666);
      
      System.out.println("\n");
      System.out.println("Connected to : " + socket.getInetAddress());
      System.out.println("On port number : " + socket.getPort());
      System.out.println("Remote socket address : " + socket.getRemoteSocketAddress());
      System.out.println("Local socket address : " + socket.getLocalSocketAddress());
      System.out.println("Local port : " + socket.getLocalPort());
      System.out.println("\n");
    }
    
    catch(Exception e) {
      System.out.println(e);
    }
    
    finally {
      try {
        socket.close();
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}
