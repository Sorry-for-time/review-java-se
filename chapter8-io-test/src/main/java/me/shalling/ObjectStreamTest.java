package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>对象流测试用例</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/8 22:30
 */
public class ObjectStreamTest {
    /**
     * @description 将对象写入到文件当中
     */
    @Test
    public void objectOutputStreamTest() {
        try (
                ObjectOutputStream objectOutputStream
                        = new ObjectOutputStream(new FileOutputStream("src/main/resources/objectStream.bin"))
        ) {
            objectOutputStream.writeObject(new User("Wayne", 40, true));
            objectOutputStream.writeObject(new User("Fox", 43, true));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * @description 从文件当中读取对象
     */
    @Test
    public void objectInputStreamTest() {
        try (
                ObjectInputStream objectInputStream
                        = new ObjectInputStream(new FileInputStream("src/main/resources/objectStream.bin"))
        ) {
            User o = (User) objectInputStream.readObject();
            User o2 = (User) objectInputStream.readObject();
            System.out.println(o);
            System.out.println(o2);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
