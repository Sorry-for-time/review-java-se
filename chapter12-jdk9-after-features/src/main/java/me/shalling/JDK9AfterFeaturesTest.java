package me.shalling;

import org.junit.jupiter.api.Test;

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
}