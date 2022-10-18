package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
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

    /**
     * @description Stream 新加 API 测试
     */
    @Test
    public void streamNewApiTest() {
        List<Integer> integers = List.of(12, 12, 24, 50, 56, 67, 46);
        // 截取在遇到满足条件前的所有元素(意思一旦遇到不满足的条件, 直接终止)
        integers.stream().takeWhile(e -> e <= 50).forEach(e -> System.out.print(e + "\t")); // 12 12 24 50
        System.out.println();
        // 返回在不满足条件元素后的所有元素(不进行二次判断, 即使后面存在满足条件的元素)
        integers.stream().dropWhile(e -> e < 50).forEach(e -> System.out.print(e + "\t")); // 50 56 67 46
        System.out.println();
        // 创建形参为单个 null 的实例
        Stream<Object> objectStream = Stream.ofNullable(null);
        objectStream.forEach(System.out::println);
        // iterate 方法新加终止条件
        Stream.iterate(1, v -> v <= 10, v -> v + 1).forEach(e -> System.out.print(e + "\t"));
        // 1 2 3 4 5 6 7 8 9 10
    }

    /**
     * @description Optional 新添加返回 Stream 流方法
     */
    @Test
    public void optionalNewStreamAPI() {
        ArrayList<Integer> integerArrayList = new ArrayList<>(4);
        Stream.iterate(1, v -> v <= 4, v -> v + 1).forEach(integerArrayList::add);
        Optional<ArrayList<Integer>> integerArrayList1 = Optional.ofNullable(integerArrayList);
        integerArrayList1.stream().flatMap(Collection::stream).forEach(e -> System.out.print(e + "\t"));
    }

    /**
     * @description JDK10 局部变量类型自动推断 -> 愉快的使用 var 定义
     */
    @Test
    public void localVariableTypeJudge() {
        var ints = new int[2];
        var list = new ArrayList<Integer>();
        Stream.generate(() -> (int) (Math.random() * 100)).limit(4).forEach(list::add);
        System.out.println(ints.getClass().getTypeName());
        System.out.println(list.getClass().getTypeName());
        for (var integer : list) {
            System.out.println(integer);
        }
        var i = Math.random(); // type: double
        System.out.println(i);
    }
}
