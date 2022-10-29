package me.shalling.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.annotations}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/1 10:36
 */
@Target(ElementType.TYPE_PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotationTwo {
  String[] value() default "ANNOTATION_TYPE";
}
