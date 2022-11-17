import me.shalling.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Shalling
 * @version v0.01
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/11/17 12:48
 */
public class RecordTest {
  @Test
  public void recordOneTest() {
    Person person = new Person("FOX", 23, "nothing", true, "1995/03/01");
    Person person1 = new Person("FOX", 23, "nothing", true, "1995/03/01");
    // 对于 record 数据类型而言, 重写了 toString() 方法
    System.out.println(person); // Person[name=FOX, age=23, fun=nothing, sex=true, birth=1995/03/01]
    // 以及重写了 equals() 和 hashCode() 方法
    System.out.println(person.sex()); // true
    System.out.println(person1.equals(person)); // true

    Assertions.assertEquals(true, person.sex());
    Assertions.assertEquals(true, person1.equals(person));
    Assertions.assertEquals("Person[name=FOX, age=23, fun=nothing, sex=true, birth=1995/03/01]",
      person.toString());
  }

  @AfterAll
  public static void resultLog() {
    System.out.println("END: 应该啥问题都没有了...");
  }
}
