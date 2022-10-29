package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>Optional 类测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/16 1:13
 */
public class OptionalClassTest {
  @Test
  public void optionalTest() {
    User wayneUser = new User(12, "Wayne");

    // 创建一个 Optional 实例, 参数必须为非空
    Optional<User> notNullOption = Optional.of(wayneUser);
    System.out.println(notNullOption);

    // 创建一个空的 Optional 实例
    Optional<Object> nullOption = Optional.empty();
    System.out.println(nullOption);

    // 创建一个参数可以为空的 Optional 实例
    wayneUser = null;
    Optional<User> nullableOption = Optional.ofNullable(wayneUser);

    // 是否存在对象
    System.out.println(nullableOption.isPresent());
    // orElse, 如果为空, 那么返回设置的值
    System.out.println(nullableOption.orElse(new User(23, "Fox")));
  }
}
