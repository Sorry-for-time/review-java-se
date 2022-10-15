package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/15 11:31
 */
public class BuiltInFunctionalInterfaceTest {
    @Test
    public void consumerInfTest() {
        Consumer<Integer> consumer = num -> System.out.println(num * 2);
        consumer.accept(12);
    }

    @Test
    public void supplierTest() {
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100);
        for (int i = 0; i < 3; ++i) {
            System.out.println(supplier.get());
        }
    }

    @Test
    public void functionTest() {
        // 对类型为 Integer 的对象进行操作, 返回结果为 String 的值
        Function<Integer, String> stringFunction = num -> String.valueOf(num).repeat(2);
        System.out.println(stringFunction.apply(23));
    }

    @Test
    public void predicateTest() {
        // 确定类型为 String 的对象是否满足定义好的规则条件, 通过 test(String str) 返回布尔值
        Predicate<String> predicate = str -> null != str && str.contains("tag") && str.length() > 3;
        System.out.println(predicate.test("is a simple tage")); // false
        System.out.println(predicate.test("is a simple  flag")); // tag
    }
}
