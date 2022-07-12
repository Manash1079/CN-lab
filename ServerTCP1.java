import java.net.*;
import java.io.*;

public class ServerTCP1 {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(6666);

      Socket socket = serverSocket.accept();

      DataInputStream din = new DataInputStream(socket.getInputStream());

      String msg = din.readUTF();
      System.out.println(msg);

      DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

      dout.writeUTF(msg);

      socket.close();
      serverSocket.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
