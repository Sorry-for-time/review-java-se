package me.shalling.annotations;

import java.lang.annotation.*;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>自定义注解1</h1>
 * @package {me.shalling.annotations}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/30 23:00
 */
@Retention(RetentionPolicy.RUNTIME) // 指定在运行时仍然保留元信息
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD}) // 限制修饰的范围
@Documented // 表示所修饰的注解在被 javadoc 解析时, 保留下来
@Repeatable(MyAnnotations.class)
public @interface CustomAnnotationOne {
    // 允许通过 default 关键字进行定义默认值
    String[] value() default {"hello", "hi"};

    // 允许定义多个
    int FACTOR() default 2;
}
