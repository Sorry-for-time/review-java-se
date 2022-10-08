package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>数据流测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/8 21:24
 */
public class DataStreamTest {
    /**
     * @description 写入数据流测试
     */
    @Test
    public void dataOutputStreamTest() {
        try (DataOutputStream dataOutputStream
                     = new DataOutputStream(new FileOutputStream("src/main/resources/dataStreamTest.bin"))
        ) {
            dataOutputStream.writeInt(23);
            dataOutputStream.writeChar('A');
            dataOutputStream.writeUTF("how are you today?\nI have seen better!");
            dataOutputStream.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * @description 读取数据流测试
     */
    @Test
    public void dataInputStreamTest() {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/main/resources/dataStreamTest.bin"))) {
            int i = dataInputStream.readInt();
            char c = dataInputStream.readChar();
            String s = dataInputStream.readUTF();
            System.out.println(i);
            System.out.println(c);
            System.out.println(s);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
