package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/1 19:12
 */
public class Collection1Test {
    @Test
    public void collection1Test() {
        Collection<String> collection = new ArrayList<>(100);
        collection.add("A");
        collection.add("B");
        collection.add("C");
        collection.addAll(collection.stream().toList());
        System.out.println(collection);
        collection.forEach(System.out::printf);
        Object[] objects = collection.toArray();
        System.out.println();
        System.out.println(Arrays.toString(objects));
        Iterator<String> iterator = collection.iterator();
        System.out.println();
        // 迭代器测试
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        System.out.println();
        collection.forEach(System.out::print);
        System.out.println();
        iterator.forEachRemaining(System.out::print);
        int[] f = {1, 2, 3, 4};
        for (var i : f) {
            System.out.println(i);
        }
        Arrays.stream(f).filter(e -> e >= 2).map(e -> e * 3).forEach(System.out::print);
    }

    @Test
    public void collectionRemoveTest() {
        List<Object> list = new ArrayList<>();
        list.add(1); // 通过自动装箱包装成 Integer 类型实例
        list.add(2);
        list.add(3);
        list.remove(2); // 此时调用的重载方法是根据索引取去删除元素, 删除了 3
        System.out.println(list); // [1, 2]
        // 此时调用的重载方法是根据传入对象的 equals(Object o) 方法进行比较, 判断是否删除
        list.remove(new Integer(2)); // 删除的是 2
        System.out.println(list); // [1]
    }
}
