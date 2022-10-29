package me.shalling.entity;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.entity}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/12 18:46
 */
public class User {
  public final String VERSION_UID = "v0.01";
  private int age;
  private String name;

  public User() {
  }

  private User(String name) {
    this.name = name;
  }

  public User(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void show() {
    System.out.println("this just a boring but brief test function");
  }

  private void sayHi(String name) {
    System.out.println("hi~ " + name);
  }

  @Override
  public String toString() {
    return "User{" +
      "age=" + age +
      ", name='" + name + '\'' +
      '}';
  }
}
