package me.shalling;

import org.junit.jupiter.api.Test;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/2 0:49
 */
public class CustomIterableTest {
    @Test
    public void customIterableTest() {
        Humans strings = new Humans();
        strings.forEach(System.out::print);
        System.out.println();
        System.out.println("=".repeat(23));
        for (String string : strings) {
            System.out.print(string + "\t");
        }
    }
}
