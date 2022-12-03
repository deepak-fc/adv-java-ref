import java.net.*;
import java.io.*;

public class Client {
  public static void main(String[] args) throws IOException {
    
    Socket socket = null;
    BufferedReader reader = null;
    
    try {
    
      socket = new Socket("localhost", 6666);
      System.out.println("\n");  
      System.out.println("[ Connected to > " + socket.getInetAddress() + " on port > " + socket.getPort() + " ]");

      reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("\nEnter file name: ");
      String fileName = reader.readLine();
      sendMessage(socket, fileName);
      
      String serverMessage = receiveMessage(socket);
      System.out.println(serverMessage);
      
      System.out.println("\n");
    }
    
    catch (Exception e) {
      System.out.println(e);
    }
    
    finally {
      try {
        socket.close();
        System.out.println("[ Disconnected from server ]\n");
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
