package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Locale;
import java.util.function.Consumer;

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

    @Test
    public void lambdaSecondTest() {
        // Consumer<String> consumer = (String str) -> System.out.println(str.toUpperCase(Locale.ROOT));
        // 如果类型参数确定, 则可以由编译器自动推到而出, 省略类型标注, 对于单个参数的形参列表, 还允许直接省略 ()
        Consumer<String> consumer = str -> System.out.println(str.toUpperCase(Locale.ROOT));
        consumer.accept("how are you today?");

        // 如果不是涉及其它逻辑, 还可以进一步简化为 "方法引用" 写法
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("I HAVE SEEN BETTER!");
    }

    @Test
    public void lambdaThirdTest() {
        /* LogOut logOut = (String str) -> {
            return str.toUpperCase(Locale.ROOT);
        }; */

        LogOut logOut = str -> str.toUpperCase(Locale.ROOT);
        System.out.println(logOut.backLog("everything will leave"));

        LogOut logOut1 = String::toUpperCase;
        System.out.println(logOut1.backLog("and the world will back calm"));
    }
}


@FunctionalInterface // 可以使用 @FunctionalInterface 注解来限制接口里的方法数量始终为一个
interface LogOut {
    String backLog(String str);
}
