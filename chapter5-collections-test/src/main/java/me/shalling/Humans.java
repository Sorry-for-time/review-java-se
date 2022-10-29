package me.shalling;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/2 0:44
 */
public class Humans implements Iterable<String> {
  @Override
  public Iterator<String> iterator() {
    return new Iterator<>() {
      private int a = 23;

      @Override
      public boolean hasNext() {
        return a > 0;
      }

      @Override
      public String next() {
        return String.valueOf(a--);
      }
    };
  }

  @Override
  public void forEach(Consumer<? super String> action) {
    for (int i = 0; i < 12; i++) {
      action.accept(String.valueOf(i));
    }
  }
}


