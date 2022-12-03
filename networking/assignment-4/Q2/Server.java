import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
  public static void main(String[] args) throws IOException {
    
    ServerSocket serverSocket = null;
    Socket socket = null;
    
    try {
      serverSocket = new ServerSocket(6666);
      System.out.println("[ Waiting for connection ]");
      socket = serverSocket.accept();
      System.out.println("[ Connected to client > " + socket.getInetAddress() + " ]");
      
      Date dateAndTime = new Date();
      sendMessage(socket, dateAndTime.toString());
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
  
  public static void sendMessage(Socket socket, String message) throws IOException {
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    out.writeUTF(message); 
  }
  
  public static String receiveMessage(Socket socket) throws IOException {
    DataInputStream in = new DataInputStream(socket.getInputStream());
    return in.readUTF();
  }
}
