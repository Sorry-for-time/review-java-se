package me.shalling;

import org.junit.jupiter.api.Test;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>String 测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/26 16:58
 */
public class StringTest {
  @Test
  public void stringTest() {
    char[] chars = {'1', '2', '3', '4'};
    String s = new String(chars, 0, chars.length); // 通过构造器
    System.out.println(s);
    System.out.println(s == "1234"); // false
    System.out.println("-".repeat(20));
    String s1 = "1234"; // 通过字面量的形式创建
    String s2 = "1234";
    System.out.println(s1 == s2); // true
    System.out.println(s1 == "1234"); // true
    System.out.println(s1 == new String("1234")); // false
  }

  @Test
  public void stringConcatTest() {
    String s1 = "JavaEE";
    String s2 = "Hadoop";

    String s3 = "JavaEEHadoop";
    String s4 = "JavaEE" + "Hadoop";
    String s5 = s1 + "Hadoop";
    String s6 = "JavaEE" + s2;

    System.out.println(s3 == s4); // true
    System.out.println(s3 == s5); // false
    System.out.println(s3 == s6); // false
    System.out.println(s5 == s6); // false

    System.out.println(s5.intern() == s6.intern());
  }
}
