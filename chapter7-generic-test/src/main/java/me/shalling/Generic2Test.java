package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>有条件的泛型测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/5 14:52
 */
public class Generic2Test {
  @Test
  public void generic2Test() {
    List<? extends Human> extendsList;
    List<? super Human> superList;

    ArrayList<Human> humanArrayList = new ArrayList<>();
    ArrayList<Student> studentArrayList = new ArrayList<>();
    ArrayList<Object> objectArrayList = new ArrayList<>();

    extendsList = humanArrayList;
    extendsList = studentArrayList;
    // extendsList = objectArrayList; // 编译不通过

    superList = humanArrayList;
    // superList = studentArrayList; // 编译不通过
    superList = objectArrayList;

    // extendsList.add(new Human()); // 编译不通过
    // extendsList.add(new Student()) // 编译不通过

    superList.add(new Student());
    superList.add(new Human());
    // superList.add(new Object()); // 编译不通过, 子类允许赋予父类, 父类不允许赋予子类

    Human human = extendsList.get(0);
    Object human1 = extendsList.get(0);
    Object object = superList.get(0);
    // Human human2 = superList.get(0); // 编译不通过
  }
}

class Human {
}

class Student extends Human {
}
