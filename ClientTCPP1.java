import java.io.*;
import java.net.*;
import java.util.*;

public class ClientTCPP1 {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 6666)) {
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      Scanner sc = new Scanner(System.in);
      String msg = null;

      while (!"exit".equalsIgnoreCase(msg)) {
        msg = sc.nextLine();

        out.println(msg);

        System.out.println("Server: " + in.readLine());
      }

      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
