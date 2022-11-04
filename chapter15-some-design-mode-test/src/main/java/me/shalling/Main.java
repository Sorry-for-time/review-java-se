package me.shalling;

/**
 * just simple test
 *
 * @author Shalling
 * @version v0.01
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/4 21:06
 */
public class Main {
  public static void main(String[] args) {
    User s = User.build().age(23).name("Wayne");
    System.out.println(s);
  }
}
