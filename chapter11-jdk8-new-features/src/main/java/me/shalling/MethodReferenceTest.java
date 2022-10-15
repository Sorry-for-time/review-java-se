package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>方法引用测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/15 15:48
 */
public class MethodReferenceTest {
    /**
     * @description 方法引用测试类
     */
    private static final class Creature {
        public static void deathTime(long time) {
            System.out.println(time);
        }

        public void hint(String str) {
            System.out.println(str);
        }

        public String toUpper() {
            return "a new day";
        }
    }

    /**
     * @description 对象::实例方法名
     */
    @Test
    public void objectMethodReferenceTest() {
        Creature creature = new Creature();
        Consumer<String> consumer = creature::hint;
        consumer.accept("Eagle");
    }

    /**
     * @description 类::静态方法名
     */
    @Test
    public void classStaticMethodReferenceTest() {
        Consumer<Long> consumer = Creature::deathTime;
        consumer.accept(23L);
    }

    /**
     * @description 类::实例方法名
     */
    @Test
    public void classObjectMethodReferenceTest() {
        Creature creature = new Creature();
        Function<Creature, String> stringFunction = Creature::toUpper;
        System.out.println(stringFunction.apply(creature));

        // origin lambda
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("a", "c"));

        // new style
        Comparator<String> comparator2 = String::compareTo;
        System.out.println(comparator2.compare("a", "b"));
    }
}
