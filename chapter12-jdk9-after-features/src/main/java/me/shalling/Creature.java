package me.shalling;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>JDK9 接口新属性测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/17 22:54
 */
public interface Creature {
    /**
     * @description jdk9 之后允许接口里定义私有方法
     */
    private void consume() {
        System.out.println("here just a simple test");
    }

    /**
     * @description 此时方法不是静态的, 无法直接通过接口调用, 需要接口的实现类对象去调用
     */
    default void invokeConsume() {
        this.consume();
    }

    /**
     * @description 只允允许通过接口去调用
     */
    static void foo() {
        System.out.println("foo");
    }

    void printFlag(String str);
}
