package me.shalling;

import org.junit.jupiter.api.Test;

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
}
