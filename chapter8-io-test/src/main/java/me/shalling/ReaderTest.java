package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>FileWriter 和 FileReader 测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/7 22:48
 */
public class ReaderTest {
  /**
   * @description FileReader && FileWriter 测试
   */
  @Test
  public void readerFirstTest() {
    // 创建 File 实例对象
    File writeFile = new File("src/main/resources/hi.ts");
    File readFile = new File("src/main/resources/hello.txt");
    // 如果文件不存在, 那么先进行创建
    if (!readFile.exists()) {
      try {
        boolean itSuccess = writeFile.createNewFile();
        if (!itSuccess) {
          System.exit(2);
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    try (
      BufferedReader bufferedReader = new BufferedReader(new FileReader(readFile));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writeFile, true), 10)
    ) {
      // 创建一个用于批量接收 writer 读取字符的数组
      char[] charsBuffer = new char[10];
      // 记录读取到的字符数
      int readLen = bufferedReader.read(charsBuffer);
      while (readLen != -1) {
        // 将 char 型数组指定范围数据写入到文件但当中
        bufferedWriter.write(charsBuffer, 0, readLen);
        // 重新读取
        readLen = bufferedReader.read(charsBuffer);
      }
      bufferedWriter.write("// when you fail\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
