package me.shalling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/15 16:52
 */
public class ConstructorReferenceTest {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Human {
        private String name;
    }

    /**
     * @description 构造器引用测试
     */
    @Test
    public void constructorReferenceTest() {
        // Supplier<Human> humanSupplierWithNoArg = () -> new Human();
        Supplier<Human> humanSupplierWithNoArg = Human::new; // 简化
        System.out.println(humanSupplierWithNoArg.get());

        Supplier<Human> humanSupplierWithFullArg = () -> new Human("Wayne");
        System.out.println(humanSupplierWithFullArg.get());

        Function<String, Human> stringHumanFunction = Human::new;
        System.out.println(stringHumanFunction.apply("Fox"));
    }

    /**
     * @description 数组引用测试
     */
    @Test
    public void arrayReferenceTest() {
        Function<Integer, String[]> mapper = String[]::new;
        System.out.println(Arrays.toString(mapper.apply(3)));
    }
}
