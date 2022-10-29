package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
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

  /**
   * @description 方法补充测试
   */
  @Test
  public void multiStreamTest() {
    ArrayList<Integer> integerArrayList = new ArrayList<>();

    // 生成一个并行流
    Stream<Integer> parallel = Stream.generate(() -> (int) (Math.random() * 100)).limit(10).parallel();

    // 填充元素
    parallel.forEach(integerArrayList::add);

    integerArrayList
      .stream()
      .sorted((a, b) -> b - a)
      .forEach(e -> System.out.print(e + "\t"));

    System.out.println();
    // 全部匹配才返回 true, 否则一个就返回 false
    System.out.println(integerArrayList.stream().allMatch(e -> e > 40));
    // 只要一个匹配就返回 true
    System.out.println(integerArrayList.stream().anyMatch(e -> e > 40));
    // 统计
    System.out.println(integerArrayList.parallelStream().filter(e -> e > 40).count());
    // 求最大
    Optional<Integer> max = integerArrayList.stream().max(Integer::compare);
    System.out.println(max.isEmpty() ? "is not get" : max.get());
    // 求最小
    Optional<Integer> min = integerArrayList.stream().min(Integer::compare);
    System.out.println(min.isEmpty() ? "is not get" : min.get());
  }

  /**
   * @description reduce (规约)方法测试
   */
  @Test
  public void streamReduceTest() {
    Integer reduceValue = Stream
      .iterate(1, (e) -> e + 1)
      .limit(9)
      // 初始值, 计算表达式 -> 将前一个计算的结果传递给后一个计算, 以此求 1 + 2 + 3 + ... + 9 的值
      .reduce(0, (nextSumValue, currentItem) -> {
        System.out.println(currentItem + ": " + nextSumValue);
        return currentItem + nextSumValue;
      });
    System.out.println(reduceValue); // 45

    Optional<Integer> reduceValue2 = Stream
      .iterate(1, (e) -> e + 1)
      .limit(9)
      .reduce(Integer::sum);
    System.out.println(reduceValue2.isEmpty() ? "is not get value" : reduceValue2.get()); // 45
  }

  /**
   * @description 收集方法测试
   */
  @Test
  public void collectTest() {
    List<Integer> integerList = Stream.iterate(1, prev -> prev + 1).limit(9).collect(Collectors.toList());
    Set<Integer> set = Stream.iterate(1, prev -> prev + 1).limit(9).collect(Collectors.toSet());

    integerList.forEach(e -> System.out.print(e + "\t"));
    System.out.println();
    set.forEach(e -> System.out.print(e + "\t"));
  }
}
