import java.net.*;

public class Client {
  public static void main(String[] args) {
    
    Socket socket = null;
    
    try {
      socket = new Socket("localhost", 6666);
      System.out.println("[ Connected to > " + socket.getInetAddress() + " on port > " + socket.getPort() + " ]");
    }
    
    catch (Exception e) {
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
