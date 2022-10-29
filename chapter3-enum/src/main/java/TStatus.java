/**
 * @author Shalling
 * @version v0.01
 * @description <h1>enum 的使用</h1>
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/30 9:22
 */
public enum TStatus implements Show {
  // 使用 JDK5.0 之后的版本, 定义枚举类实例成员需要前置, 且每个实例间用逗号进行分隔
  // enum 类型 默认继承于 java.lang.Enum, 而不是 Object
  // 省略了 static final 类型和 new
  // 如果没用属性, 允许直接省略()
  READY(0, "wait running"),
  // 如果继承了类或者实实现了某个接口, 允许重写/实现 方法实现自定义述求
  RUNNING(1, "in running") {
    @Override
    public String toString() {
      return super.toString();
    }

    @Override
    public void show() {
      System.out.println("just show");
    }
  },
  BLOCKED(2, "blocked"),
  DEATH(4, "death");


  private final int code;
  private final String description;

  // 提供私有化构造器, 可以省略 private(默认就是 private)
  TStatus(int code, String description) {
    this.code = code;
    this.description = description;
  }

  // 根据实际需求提供 getter
  public int getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public void show() {

  }
  // 一般不重写 toString, 默认打印枚举实例的常量名称, 除非特殊需求才进行重写
}

interface Show {
  void show();
}
