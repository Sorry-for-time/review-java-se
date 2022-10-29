package me.shalling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since ${DATE} ${TIME}
 */
public class GenericTest {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    ArrayList<Integer> list1 = new ArrayList<>();
    for (int i = 1; i <= 3; ++i) {
      list.add(String.valueOf(i));
      list1.add(i);
    }
    showList(list);
    System.out.println();
    showList(list1);
  }

  public static <E> void showList(List<E> list) {
    list.forEach(e -> {
      System.out.print(e + "\t");
    });
  }

  /**
   * @param list 进行遍历的集合
   * @brief ? 可以作为通配符, 使得 List<?> 作为公共父类
   */
  @SuppressWarnings("WhileLoopReplaceableByForEach")
  public static void displayList(List<?> list) {
    // list.add("12"); // 此时不允许添加数据
    Iterator<?> iterator = list.iterator();
    while (iterator.hasNext()) {
      // 此时取得的是 Object 类型
      Object next = iterator.next();
      System.out.print(next + "\t");
    }
  }
}
