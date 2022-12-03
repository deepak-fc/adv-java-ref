import java.net.*;
import java.io.*;

public class Client {
  public static void main(String[] args) throws IOException {
    
    Socket socket = null;
    
    try {
    
      socket = new Socket("localhost", 6666);
      System.out.println("\n");  
      System.out.println("[ Connected to > " + socket.getInetAddress() + " on port > " + socket.getPort() + " ]");
      System.out.println("[ ECHO ]: " + receiveMessage(socket));
      System.out.println("\n");
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
  
  public static void sendMessage(Socket socket, String message) throws IOException {
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    out.writeUTF(message); 
  }
  
  public static String receiveMessage(Socket socket) throws IOException {
    DataInputStream in = new DataInputStream(socket.getInputStream());
    return in.readUTF();
  }
}
