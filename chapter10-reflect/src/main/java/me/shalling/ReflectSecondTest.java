package me.shalling;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>just test some Reflect relative methods</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/13 16:45
 */
public class ReflectSecondTest {
    public Object getInstance(String classPathName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return Class.forName(classPathName).newInstance();
    }

    @Test
    public void getInstanceTest() {
        try {
            Object instance = getInstance("me.shalling.entity.User");
            System.out.println(instance);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static class Creature<T> {
    }

    static class Version extends Creature<String> {
    }

    @Test
    public void getSuperClassTest() {
        // 取得类的父类
        Class<Version> versionClass = Version.class;
        System.out.println(versionClass);
        // 取得类的带泛型的父类
        Type genericSuperclass = versionClass.getGenericSuperclass();
        System.out.println(genericSuperclass.getTypeName());
        // 取得泛型参数
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type argument : actualTypeArguments) {
            System.out.println(argument.getTypeName());
            // Class 实现了 Type -> 对于 ORM 框架来说非常重要, 可以读取到类型
            // 在确定类型的情况下可以进行强转
            Class<?> stringClass = (Class<?>) argument;
            try {
                Constructor<?> constructor = stringClass.getConstructor(String.class);
                Object s = constructor.newInstance("233");
                System.out.println(s);
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                     InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
