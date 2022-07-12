import java.io.*;
import java.net.*;

public class ServerTCPP1 {
  public static void main(String[] args) {
    ServerSocket serverSocket = null;

    try {
      serverSocket = new ServerSocket(6666);
      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("New Client Connected " + socket.getInetAddress().getHostAddress());

        ClientHandlerP1 clientSocket = new ClientHandlerP1(socket);
        new Thread(clientSocket).start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (serverSocket != null) {
        try {
          serverSocket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

class ClientHandlerP1 implements Runnable {
  private final Socket socket;

  public ClientHandlerP1(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    PrintWriter out = null;
    BufferedReader in = null;

    try {
      out = new PrintWriter(socket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      String msg;
      while ((msg = in.readLine()) != null) {
        System.out.println("Client: " + msg);
        out.println(msg);
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (out != null) {
          out.close();
        }
        if (in != null) {
          in.close();
          socket.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}