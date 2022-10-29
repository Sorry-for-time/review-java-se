import org.junit.jupiter.api.Test;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {PACKAGE_NAME}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/30 9:28
 */
public class EnumTest {
  @Test
  public void customEnumTest() {
    System.out.println(CustomEnum.AUTUMN);
    System.out.println(CustomEnum.class.getSuperclass().getName()); // java.lang.object
  }

  @Test
  public void builtInEnumTest() {
    System.out.println(TStatus.READY);
    System.out.println(TStatus.class.getSuperclass().getName());
    TStatus[] values = TStatus.values();

    System.out.println("=".repeat(23));
    // 取得枚举类内所有的枚举实例
    for (TStatus status : values) {
      System.out.println(status);
    }
    System.out.println("=".repeat(23));
    TStatus.RUNNING.show();

    // 根据传入的名称返回枚举类内部对应的枚举实例, 如果没获取到, 则抛出异常
    TStatus tStatus = TStatus.valueOf("READY");
    System.out.println(tStatus);
  }
}
