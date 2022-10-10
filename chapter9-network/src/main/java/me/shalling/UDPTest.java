package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>UDP 网络编程简单测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/10 18:49
 */
public class UDPTest {
    /**
     * @description 发送端测试
     */
    @Test
    public void sendTest() {
        try (
                DatagramSocket datagramSocket = new DatagramSocket();
        ) {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String message = "how are you today?";
            byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
            datagramSocket.send(new DatagramPacket(messageBytes, messageBytes.length, inetAddress, 6553));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @description 接收端测试
     */
    @Test
    public void receiveTest() {
        try (
                DatagramSocket datagramSocket = new DatagramSocket(6553);
        ) {
            byte[] bytes = new byte[100];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            System.out.println("receive value" + ": " + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
