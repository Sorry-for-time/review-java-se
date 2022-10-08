package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>标准输入输出流测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/8 17:01
 */
public class StandardInputAndOutputStreamTest {
    @Test
    public void standardInputStreamTest() {
        InputStream in = System.in; // System.in 是一个字节流
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        ) {
            while (true) {
                String s = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                    break;
                }
                System.out.println(s);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void standardOutputStreamTest() {
        // 备份引用
        PrintStream backUp = System.out;
        try (
                PrintStream ps
                        = new PrintStream(
                        new FileOutputStream("src/main/resources/consoleRedirect.txt", false), true)
        ) {
            // 重定向输出位置到文件
            System.setOut(ps);
            for (int i = 0; i <= 255; ++i) {
                System.out.print((char) i + "\t");
                if (i % 10 == 0) {
                    System.out.println();
                }
            }
            System.setOut(backUp); // 重定向回控台窗口
            System.out.println("ALL IS DONE!");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
