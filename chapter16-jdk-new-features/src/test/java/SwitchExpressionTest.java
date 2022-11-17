import java.util.Scanner;

/**
 * <p>Java17 的 switch 表达式简单使用</p>
 *
 * @author Shalling
 * @version v0.01
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/17 16:05
 */
public class SwitchExpressionTest {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("please input the string: ");
      var text = scanner.nextLine();
      // 允许通过这种方式来做一些处理
      var result = switch (text) {
        case "hello", "hi" -> "how are you";
        case "HELLO" -> "HOW ARE YOU";
        // 如果需要顺便做一些操作, 那么可以通过 {} 包括起来, 但是必须要使用 yield 产生一个值
        case "special" -> {
          System.out.println("em... 只是一条普通的提示输出");
          yield 1 << 2;
        }
        default -> "NO RESPONDING";
      };
      System.out.println(result);

      // 如果是匹配到了 special 的话, 下面的输出为: class java.lang.Integer
      // 在使用 var 接收不同数据类型返回的情况下当成包装类处理了(可序列化和可比较...)
      System.out.println(result.getClass());
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}
