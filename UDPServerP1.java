import java.net.*;
import java.io.*;

public class UDPServerP1 {
  public static void main(String[] args) throws IOException {
    DatagramSocket dSocket = new DatagramSocket(6666);
    byte buff[] = new byte[1024];

    DatagramPacket rcvdPacket = new DatagramPacket(buff, buff.length);
    dSocket.receive(rcvdPacket);

    String rcvd = new String(rcvdPacket.getData());
    System.out.println(rcvd);

    String msg = "Hello From Server";
    byte send[] = msg.getBytes();

    InetAddress senderIp = rcvdPacket.getAddress();
    int senderPort = rcvdPacket.getPort();

    DatagramPacket sentPacket = new DatagramPacket(send, send.length, senderIp, senderPort);
    dSocket.send(sentPacket);

    dSocket.close();
  }
}
