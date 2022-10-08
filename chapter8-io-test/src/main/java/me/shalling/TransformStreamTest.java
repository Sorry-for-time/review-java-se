package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/8 16:07
 */
public class TransformStreamTest {
    @Test
    public void inputStreamReaderTest() {
        try (
                // 实现字节输入流到字符输入流的转换
                InputStreamReader inputStreamReader
                        = new InputStreamReader(new FileInputStream("src/main/resources/hi.ts"), StandardCharsets.UTF_8)
        ) {
            char[] chars = new char[10];
            int readLength = inputStreamReader.read(chars);
            while (readLength != -1) {
                System.out.print(new String(chars, 0, readLength));
                readLength = inputStreamReader.read(chars);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void inputSteamReaderAndOutputStreamWriterTest() {
        try (
                InputStreamReader inputStreamReader
                        = new InputStreamReader(new FileInputStream("src/main/resources/hi.ts"), StandardCharsets.UTF_8);
                OutputStreamWriter outputStreamWriter
                        = new OutputStreamWriter(new FileOutputStream("src/main/resources/hi-gbk.ts"), "GBK")
        ) {
            char[] chars = new char[10];
            int readLength = inputStreamReader.read(chars);
            while (readLength != -1) {
                outputStreamWriter.write(chars, 0, readLength);
                readLength = inputStreamReader.read(chars);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
