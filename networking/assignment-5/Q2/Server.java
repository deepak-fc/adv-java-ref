import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
  public static void main(String[] args) throws IOException {
    
    ServerSocket serverSocket = null;
    Socket socket = null;
    BufferedReader reader = null;
    
    try {
      serverSocket = new ServerSocket(6666);
      
      System.out.println("\n\n");
      System.out.println("[ Waiting for connection ]");
      socket = serverSocket.accept();
      System.out.println("[ Connected to client > " + socket.getInetAddress() + " ]");
      
      String clientMessage = "";
      clientMessage = receiveMessage(socket);
      
      File file = new File(clientMessage);
      String fileContent = "";
      int intCharacter;
      
      if(file.isFile()) {
        reader = new BufferedReader(new FileReader(file));
        while((intCharacter = reader.read()) != -1) {
          fileContent += (char) intCharacter;
        }
        sendMessage(socket, fileContent);
      }
      
      else {
        sendMessage(socket, "[ERROR]: File does not exist on server.");
      }
    }
    
    catch (Exception e) {
      System.out.println(e);
    }
    
    finally {
      try {
        socket.close();
        serverSocket.close();
        System.out.println("[ Disconnected from client ]\n");
        reader.close();
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
