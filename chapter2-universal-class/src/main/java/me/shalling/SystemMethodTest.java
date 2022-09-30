package me.shalling;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/29 17:16
 */
public class SystemMethodTest {
    @Test
    public void systemMethodTest() {
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void testDecimal() {
        BigDecimal bigDecimal = new BigDecimal("31231212121212121212121212312");
        BigDecimal bigDecimal1 = new BigDecimal(123123);
        System.out.println(bigDecimal1.subtract(bigDecimal));
        System.out.println(bigDecimal.divide(bigDecimal1, 3));
    }
}
