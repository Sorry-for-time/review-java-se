package me.shalling;

import org.junit.jupiter.api.Test;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/28 19:29
 */
public class StringBufferTest {
  @Test
  public void stringBasicBufferTest() {
    StringBuffer buffer = new StringBuffer(0x20);
    buffer.append(12);
    buffer.append("How");
    int v = (int) (Math.random() * 1000);
    System.out.println(v);
    System.out.println();
    for (int i = 1; i <= v; i++) {
      buffer.append(i);
    }
    System.out.println(buffer);
  }
}
