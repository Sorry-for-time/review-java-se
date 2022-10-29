package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>TCP && Socket 测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/9 15:44
 */
public class TCPTest {

  /**
   * @description 客户端模拟
   */
  @Test
  public void clientTest() {
    System.out.println("please input your message to server");
    try (
      // create socket
      Socket sendMessageSocket = new Socket(
        InetAddress.getByName("127.0.0.1"),
        6553
      );
      OutputStream sendToServerStream = sendMessageSocket.getOutputStream();
      InputStream receiveFromSeverStream = sendMessageSocket.getInputStream();
      // create a buffer stream to transform bytes value from server
      ByteArrayOutputStream transformSeverDataToString = new ByteArrayOutputStream();
      // a simple operation simulate typing message
      Scanner scanner = new Scanner(System.in)
    ) {
      // prepare message to send server
      String sendToServerMessage;
      do {
        sendToServerMessage = scanner.nextLine();
        sendToServerStream.write(sendToServerMessage.getBytes(StandardCharsets.UTF_8));
        sendToServerStream.flush();
        // send a stop flag to server
        sendMessageSocket.shutdownOutput();
        System.out.println(sendMessageSocket.isOutputShutdown() + "!".repeat(12));
      } while (!"exit".equalsIgnoreCase(sendToServerMessage)); // if send value is: "exit", exit loop

      // receive server send value from server when server prepare shutdown
      int readLength;
      byte[] buffer = new byte[10];
      while ((readLength = receiveFromSeverStream.read(buffer)) != -1) {
        transformSeverDataToString.write(buffer, 0, readLength);
      }
      System.out.println("receive the last value from server: " + transformSeverDataToString.toString(StandardCharsets.UTF_8));
      System.out.println("-".repeat(11) + "client shutdown" + "-".repeat(11));
    } catch (
      Exception exception) {
      exception.printStackTrace();
    }
  }

  /**
   * @description 服务端模拟
   */
  @Test
  public void serverTest() {
    System.out.println("=".repeat(12) + "server start!" + "=".repeat(12));
    try (
      // init basic server config
      ServerSocket serverSocket = new ServerSocket(6553);
      Socket serverListener = serverSocket.accept();
      InputStream inputStream = serverListener.getInputStream();
      OutputStream outputStream = serverListener.getOutputStream();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
    ) {
      byte[] bytes = new byte[10]; // prepare a buffer load byte from client
      String receiveValue = null;
      while (!serverListener.isInputShutdown()) {
        if (!serverListener.isOutputShutdown()) {
          int readLength = inputStream.read(bytes);
          while (readLength != -1) {
            // load value to byteArrayOutputStream
            byteArrayOutputStream.write(bytes, 0, readLength);
            // update read status
            readLength = inputStream.read(bytes);
          }
          receiveValue = byteArrayOutputStream.toString(StandardCharsets.UTF_8);
          System.out.println("CLIENT-> " + serverListener.getRemoteSocketAddress() + ": " + receiveValue);
          // clear buffer cache when output the client message
          byteArrayOutputStream.reset();
        }
        // prepare close server when match the client value equals "exit"
        if ("exit".equalsIgnoreCase(receiveValue)) {
          outputStream.write("bye".getBytes(StandardCharsets.UTF_8));
          serverListener.shutdownOutput();
          break;
        }
      }

      System.out.println("=".repeat(12) + "server shutdown!" + "=".repeat(12));
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}
