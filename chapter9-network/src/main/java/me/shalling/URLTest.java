package me.shalling;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>URL simple test</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/10 23:33
 */
public class URLTest {
  @Test
  public void urlSimpleTest() {
    URL url;
    try {
      url = new URL("https://www.baidu.com");
      System.out.println(url.getAuthority());
      System.out.println(url.getContent());
      System.out.println(url.getDefaultPort());
      System.out.println(url.getRef());
      System.out.println(url.getHost());
      System.out.println(url.getFile());
      System.out.println(url.getProtocol());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
