package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/8 15:34
 */
public class BufferedReaderAndWriterTest {
  /**
   * @description 测试文本专用读写 buffered
   */
  @Test
  public void bufferedReaderAndWriterTest() {
    File readData = new File("src/main/resources/hi.ts");
    File writeData = new File("src/main/resources/out.txt");
    try (
      BufferedReader bufferedReader = new BufferedReader(new FileReader(readData));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writeData))
    ) {
      String line = bufferedReader.readLine();
      while (line != null) {
        bufferedWriter.write(line);
        bufferedWriter.newLine();
        line = bufferedReader.readLine();
      }
      System.out.println("ALL IS DONE");
    } catch (IOException exception) {
      System.out.println(exception.getMessage());
    }
  }
}
