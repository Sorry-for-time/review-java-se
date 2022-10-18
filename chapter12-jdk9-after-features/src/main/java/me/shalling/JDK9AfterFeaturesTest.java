package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>默认测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 */
public class JDK9AfterFeaturesTest {
    @Test
    public void interfaceAllSpecifiedMethodTest() {
        Creature creature = System.out::println;
        creature.invokeConsume();
        creature.printFlag("how are you today");
        Creature.foo();
    }

    /**
     * @description 只读集合测试
     */
    @Test
    public void readOnlyCollectionTest() {
        ArrayList<Integer> integers = new ArrayList<>(4);
        Stream.iterate(1, prev -> prev + 1).limit((4)).forEach(integers::add);
        // 返回一个只读 List
        List<Integer> integers1 = Collections.unmodifiableList(integers);
        // integers1.add(12); // 报错, 不允添加
        // integers1.remove(4); // 报错, 不允许删除
        integers1.forEach(e -> System.out.print(e + "\t")); // 正常读取
        // 通过 Arrays.asList(T ...t) 返回的也是一个只读集合
        System.out.println();
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        integerList.forEach(e -> System.out.print(e + "\t")); // 正常读取
        System.out.println();
        // ====================java 9 之后========================
        List<Integer> integers2 = List.of(1, 2, 3, 4);
        integers2.forEach(e -> System.out.print(e + "\t")); // 正常读取
    }

    /**
     * @description transferTo 方法 测试
     */
    @Test
    public void fileInputStreamTransferToMethodTest() {
        try (
                BufferedInputStream fileInputStream
                        = new BufferedInputStream(new FileInputStream("read.txt"));
                BufferedOutputStream fileOutputStream
                        = new BufferedOutputStream(new FileOutputStream("write.txt", false))
        ) {
            fileInputStream.transferTo(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
