package me.shalling;


/**
 * <p>注: record 数据类型为 java14 新增</p>
 * <p>1.对于记录类型数据, 每个属性都是私有的 final 字段, 且默认实现了 toString(), equals() 和 hashCode() 方法</p>
 * <p>2.且对于 record 数据类型而言, 本身就是用 final 修饰的, 所以不允许有子记录或者子类(不允许被其它类使用 extends 继承),
 * 所以也不允许包含有抽象类型的数据方法, 所以可以理解为一个不可变的数据类</p>
 * <p>3.不能在record类的body中添加属性, 属性只能定义在类的括号后面(称为header)</p>
 * <p>3.允许在内部再封装 record 数据类型</p>
 *
 * @param name  姓名
 * @param age   年龄
 * @param fun   兴趣
 * @param sex   性别
 * @param birth 出生日期
 * @see <a href="https://docs.oracle.com/en/java/javase/14/language/records.html">有关 redcor 数据类型的官方说明/a>
 */
public record Person(String name, int age, String fun, boolean sex, String birth) {
  // 不允许定义内部非静态的私有属性, 哪怕j使用 final 修饰也不可以
  // private final String other = "";

  // 但允许定义静态的属性, 私有或者不是 final 也 OK
  private static String other = "没有感情的解说";

  // 这没问题的, 在内部再定义一个 record 数据类
  private record Other(String flag) {
    private Other {
      java.util.Objects.requireNonNull(flag);
    }
  }

  // 静态代码块也是 OK 的
  static {
    System.out.println("假装做了一些很有意义的事情1...");
  }

  // 多个也没问题
  static {
    System.out.println("假装做了一些很有意义的事情2...");
  }

  /*
  但是非静态代码块是不允许的
  {
    System.out.println();
  }
  */

  // 是允许定义内部私有方法的
  private void toAny() {
    other += other;
  }

  /**
   * 与类构造函数不同, 记录构造函数没有形参列表;
   * 但是可以如做出一些逻辑上的限制(尽管还是会为 String 类型的数据设置为 null), 如果传入参数为 null, 就抛出空指针异常
   */
  public Person {
    java.util.Objects.requireNonNull(name);
    java.util.Objects.requireNonNull(fun);
    java.util.Objects.requireNonNull(birth);
    // 还可以尝试区做一些初始化的事情...
  }

  // 这是不被允许的: 非规范记录构造函数必须委托给另一个构造函, 如上那种形式
  // public Person() { }


  // 但这没问题(但没意义)
  public Person(String name, String fun, String birth) {
    this(name, 0, fun, false, birth);
  }


  /*
  因为 record 数据类型的成员类型变量实际上都是 final 修饰的, 所以别想着 set 了
  public void setAge(int age) {
    this.age = age;
  }
  */

  /**
   * 记录类型默认实现了所有字段的只读获取属性方法, 如果没有特殊需求, 不需要重写
   * 且不以 getXxx 形式命名, 直接以参数列表的属性字段名称命名, 如下
   *
   * @return name-姓名
   */
  @Override
  public String name() {
    System.out.println("做一个很敷衍的输出印证这个重写在获取属性时被执行了");
    return name;
  }

  // 尽管记录类型已经默认重写了 toString() 等方法, 但是只要愿意, 依然可以选择自己进行重写(这样代码可能看起啦多一些???)
}
