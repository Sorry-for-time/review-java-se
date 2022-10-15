package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
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

    /**
     * @description 无限流 -> 生成流与中间链操作测试
     */
    @Test
    public void generateStreamTest() {
        Stream
                .generate(() -> (int) (Math.random() * 100)) // 生成随机整数
                .limit(100) // 截断, 限制生成数量为: 100
                .parallel() // 转换成并行流
                .distinct() // 去重, 调用 equals 和 hashCode 方法
                .filter(e -> e > 40) // 过滤
                .sorted((e1, e2) -> e2 - e1) // 自定义排序 -> 降序
                .map(e -> e * 10) // 转换
                .limit(10) // 取出前10个
                .skip(5) // 跳过前 5 个
                .map(e -> {
                    ArrayList<Integer> list = new ArrayList<>(3);
                    for (int i = 0; i < 3; ++i) {
                        list.add(e);
                    }
                    return list;
                })
                // 适合于集合里面放集合的情况, 将流中的每个值都转换成另一个流, 然后把所有的流连接成一个流
                // 简单理解: 将所有 list 里的元素进行展开, 再汇总到一个 list 里
                .flatMap(Collection::parallelStream)
                .forEach(e -> System.out.print(e + "\t")); // 输出测试(终止操作)
    }
}
