/**
 * @author Shalling
 * @version v0.01
 * @description <h1>JDK5.0 之前的2版本自定义类枚举类的实现方式</h1>
 * @package {PACKAGE_NAME}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/30 8:36
 */
public class CustomEnum {
  // 3.提供当前枚举类的多个对象
  public static final CustomEnum SPRING = new CustomEnum("spring", "春");
  public static final CustomEnum SUMMER = new CustomEnum("summer", "夏");
  public static final CustomEnum AUTUMN = new CustomEnum("spring", "秋");
  public static final CustomEnum WINTER = new CustomEnum("spring", "冬");
  // 1.设置对象属性, 并设置为 private final
  private final String name;
  private final String description;
  // 2.私有化构造器, 并给属性赋值
  private CustomEnum(String name, String description) {
    this.name = name;
    this.description = description;
  }

  // 4.设置私有属性的 get 方法
  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }


  // 5.根据需求重写 toString
  @Override
  public String toString() {
    return "CustomEnum{" +
      "name='" + name + '\'' +
      ", description='" + description + '\'' +
      '}';
  }
}
