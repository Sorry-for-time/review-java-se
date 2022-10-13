package me.shalling;

import me.shalling.entity.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>Test Reflect</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 */
public class ReflectTest {
    @Test
    public void reflectFirstTest() {
        try {
            // get the Class's instance -> reflect beginning point and source, its symbol of the class-self
            Class<User> userClass = User.class;
            // get the User class full parameters' constructor
            Constructor<User> constructor = userClass.getConstructor(int.class, String.class);

            // create an instance by the constructor's newInstance function -> this operation maybe throws some exception
            User wayne = constructor.newInstance(12, "Wayne");
            System.out.println(wayne); // User{age=12, name='Wayne'}

            // used by getMethod get the User class built-in function
            Method show = userClass.getMethod("show");

            // invoke the method, this need a relative class instance, here is "wayne", and will return a relative value
            Object invoke = show.invoke(wayne);
            System.out.println(invoke); // null

            // it can use getField get the public specified member
            Field version_uid = userClass.getField("VERSION_UID");
            System.out.println(version_uid.get(wayne)); // v.0.01

            // use userClass get the class field, here want the private field: age
            Field age = userClass.getDeclaredField("age");
            // use reflect break the private declareFiled limit, then the next stage can use set() operation modify new value
            // if not, will throw an exception
            age.setAccessible(true);
            age.set(wayne, 23);
            System.out.println(wayne); // User{age=23, name='Wayne'}

            // use getDeclaredMethod(method name, String... parameters) get the DeclaredMethod
            Method sayHi = userClass.getDeclaredMethod("sayHi", String.class);

            // use trySetAccessible() break declaredMethod read limit, and return a value to hint what this operation is success
            if (sayHi.trySetAccessible()) {
                Object returnValue = sayHi.invoke(wayne, "Wayne"); // hi~ Wayne
                System.out.println(returnValue); // null
            }

        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void reflectSecondTest() {
        Class<User> userClass = User.class;
        try {
            // get private specified constructor -> this operation will throw exceptions
            Constructor<User> declaredConstructor = userClass.getDeclaredConstructor(String.class);
            // try to set private specified constructor to accessible
            if (declaredConstructor.trySetAccessible()) {
                User fox = declaredConstructor.newInstance("Fox");
                System.out.println(fox);
            } else {
                System.out.println("set declared constructor accessible failure");
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void reflectThirdTest() {
        User lox = new User(23, "Lox");
        // used by a runtime instance object get the Class
        Class<? extends User> aClass = lox.getClass();
        System.out.println(aClass);

        //noinspection ConstantConditions
        System.out.println(aClass == User.class); // true

        try {
            // use Class.forName(String className) get the Class instance
            @SuppressWarnings("unchecked")
            Class<User> aClass1 = (Class<User>) Class.forName("me.shalling.entity.User");
            System.out.println(aClass1 == User.class); // true
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void reflectFourthTest() {
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        try {
            // use class-loader load a Class instance -> this operation will throw an exception
            Class<?> aClass = classLoader.loadClass("me.shalling.entity.User");
            System.out.println(aClass);

            // use class constructor generate an instance
            Constructor<?> constructor = aClass.getConstructor(int.class, String.class);
            User instance = (User) constructor.newInstance(12, "Fox");
            System.out.println(instance); // User{age=12, name='Fox'}
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getClassLoaderTest() {
        ClassLoader appClassLoader = ReflectTest.class.getClassLoader();
        System.out.println(appClassLoader); // jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b

        ClassLoader platformClassLoader = appClassLoader.getParent();
        System.out.println(platformClassLoader); // jdk.internal.loader.ClassLoaders$PlatformClassLoader@226a82c4

        ClassLoader parent = platformClassLoader.getParent();
        System.out.println(parent); // null, can't get initial class loader
    }

    /**
     * @description test Class -> newInstance
     */
    @Test
    public void classTest() {
        Class<User> userClass = User.class;
        try {
            // directly invoke non-parameter constructor, the class must provide a not-parameter constructor
            // and the read permission must enough -> usually set: public
            User user = userClass.newInstance();
            System.out.println(user);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}