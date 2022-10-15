package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>Stream API 测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/15 18:44
 */
public class StreamAPITest {
    /**
     * @description 无限流 -> 迭代流 测试
     */
    @Test
    public void iterateStreamTest() {
        Stream
                .iterate(0, e -> e + 2)  // 会把当前的计算结果赋传递给下一次计算
                .limit(10) // 限制生成数量
                .forEach(e -> System.out.print(e + "\t")); // 遍历输出
    }
}
