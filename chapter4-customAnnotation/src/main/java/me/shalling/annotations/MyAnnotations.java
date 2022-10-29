package me.shalling.annotations;

import java.lang.annotation.*;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.annotations}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/1 10:25
 */
@Retention(RetentionPolicy.RUNTIME) // 指定在运行时仍然保留元信息
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD}) // 限制修饰的范围
@Documented // 表示所修饰的注解在被 javadoc 解析时, 保留下来
public @interface MyAnnotations {
  CustomAnnotationOne[] value();
}
