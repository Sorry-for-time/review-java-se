package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since ${DATE} ${TIME}
 */
public class IOTest {
    @Test
    public void IOFirstTest() {
        File file = new File("src/main/resources/hello.txt");
        File file1 = new File("src/");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());

        System.out.println(Arrays.toString(file1.list()));
        System.out.println(Arrays.toString(file1.listFiles()));

        // 重命名文件
        boolean b = file.renameTo(new File("src/main/resources/hi.txt"));
    }

    @Test
    public void IOSecondTest() {
        File file = new File("D:\\33306\\Documents\\test_c\\just-tmp\\1");
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        // 创建文件夹 --> 如果父目录等不存在, 那么一并创建
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            System.out.println(mkdirs);
            System.out.println(file.exists());
            System.out.println(file.isDirectory());
        }
    }

    public void listDirectory(File dist) {
        File[] files = dist.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listDirectory(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }

    @Test
    public void IOThirdTest() {
        File file = new File("D:\\33306\\Documents\\test_c\\just-tmp");
        listDirectory(file);
    }
}