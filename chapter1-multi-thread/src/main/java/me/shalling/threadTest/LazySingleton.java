package me.shalling.threadTest;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.threadTest}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/25 15:33
 */
public class LazySingleton {
    private static LazySingleton lazySingleton;

    private final int age = 23;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        synchronized (lazySingleton) {
            if (null == lazySingleton) {
                lazySingleton = new LazySingleton();
            }
        }
        return lazySingleton;
    }
}
