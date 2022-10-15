package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>JAVA8 新特性使用测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/14 22:33
 */
public class JDK8NewFeaturesTest {
    @Test
    public void lambdaTest() {
        Comparator<Integer> comparator = (o1, o2) -> {
            System.out.println(o1 + ": " + o2);
            return Integer.compare(o1, o2);
        };
        System.out.println(comparator.compare(12, 1));
    }

}
