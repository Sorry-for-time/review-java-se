package me.shalling;

/**
 * 简单的链式调用生成测试
 *
 * @author Shalling
 * @version v0.01
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/4 20:59
 */
public class User {
  private int age;
  private String name;

  private User() {
  }

  private User(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public static User build() {
    return new User();
  }

  public static User build(int age, String name) {
    return new User(age, name);
  }

  public User age(int age) {
    this.age = age;
    return this;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String toString() {
    return "User{" +
      "age=" + age +
      ", name='" + name + '\'' +
      '}';
  }
}
