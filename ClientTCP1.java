import java.net.*;
import java.io.*;

public class ClientTCP1 {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("localhost", 6666);

      DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
      dout.writeUTF("Good Morning!");

      DataInputStream din = new DataInputStream(socket.getInputStream());
      String msg = din.readUTF();

      System.out.println(msg);

      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
