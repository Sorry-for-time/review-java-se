package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>文件流读写测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/8 0:13
 */
public class FileInputStreamAndFileOutPutSteamTest {
  @Test
  public void fileInputSteamTest() {
    // 创建 File 实例
    File readFile = new File("src/main/resources/bgc.jpg");
    File writeFile = new File("src/main/resources/backup.jpg");
    // 读 && 写文件
    try (
      BufferedInputStream bufferedInputStream
        = new BufferedInputStream(new FileInputStream(readFile), 8);
      BufferedOutputStream bufferedOutputStream
        = new BufferedOutputStream(new FileOutputStream(writeFile, false), 8)
      // 如果不在 try 表达式里进行流处理, 而是在 finally 里处理, 那么需要从外层流进行关闭(注: 关掉外层缓冲流的时候会顺便关闭内层流)
    ) {
      byte[] bytes = new byte[8];
      int readLength = bufferedInputStream.read(bytes);
      while (readLength != -1) {
        // 在写入的过程中会自动调用 flushBuffer(); --> 无需手动再手动调用 flush 方法去刷新缓冲区
        bufferedOutputStream.write(bytes, 0, readLength);
        readLength = bufferedInputStream.read(bytes);
      }
      System.out.println("ALl IS DONE!");
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}
