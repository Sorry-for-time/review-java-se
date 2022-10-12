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
    public void langClassTest() {
        try {
            Class<User> userClass = User.class;
            // get the User class full parameters constructor
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
}