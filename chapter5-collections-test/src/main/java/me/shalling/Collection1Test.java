package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

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
}
