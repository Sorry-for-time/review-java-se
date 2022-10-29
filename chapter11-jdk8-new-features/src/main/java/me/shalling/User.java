package me.shalling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>供 Optional 类进行测试的类</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/17 8:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private int age;
  private String name;
}
