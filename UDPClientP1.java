import java.io.*;
import java.net.*;

public class UDPClientP1 {
  public static void main(String[] args) throws IOException {
    InetAddress ip = InetAddress.getByName("localhost");
    DatagramSocket dSocket = new DatagramSocket();

    String msg = "Hello From Client";
    byte sendBuf[] = msg.getBytes();
    byte rcvBuf[] = new byte[1024];

    DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, ip, 6666);
    dSocket.send(sendPacket);

    DatagramPacket rcvPacket = new DatagramPacket(rcvBuf, rcvBuf.length);
    dSocket.receive(rcvPacket);

    String rcvd = new String(rcvPacket.getData());
    System.out.println(rcvd);

    dSocket.close();
  }
}
