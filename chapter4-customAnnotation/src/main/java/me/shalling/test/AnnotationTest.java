package me.shalling.test;

import me.shalling.annotations.CustomAnnotationOne;
import me.shalling.annotations.CustomAnnotationTwo;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.test}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/30 23:15
 */
public class AnnotationTest {
  @Test
  @CustomAnnotationOne(value = {"Fox", "Wayne"}, FACTOR = 23)
  public void customAnnotationOneTest() {
    System.out.println("=".repeat(23));
    Class<Foo> fooClass = Foo.class;
    Annotation[] annotations = fooClass.getAnnotations();
    for (Annotation annotation : annotations) {
      System.out.println(annotation);
    }
  }
}

@CustomAnnotationOne
class Foo<@CustomAnnotationTwo T> {
  // ...
  private T t;
}
