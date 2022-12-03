import java.net.*;
import java.io.*;

public class Server {
  public static void main(String[] args) throws IOException {
    
    ServerSocket serverSocket = null;
    Socket socket = null;
    
    while (true) {
      try {
        serverSocket = new ServerSocket(6666);
        
        System.out.println("\n\n");
        System.out.println("[ Waiting for connection ]");
        socket = serverSocket.accept();
        System.out.println("[ Connected to client > " + socket.getInetAddress() + " ]");
        
        String clientMessage = "";
        while(true) {
          clientMessage = receiveMessage(socket);
          System.out.println("[ ECHO ]: " + clientMessage);
          
          if(clientMessage.equals("end")) {
            break;
          }
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
        }
        catch (Exception e) {
          System.out.println(e);
        }
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
