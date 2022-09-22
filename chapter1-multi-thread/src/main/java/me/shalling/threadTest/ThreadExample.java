package me.shalling.threadTest;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>继承 Thread, 打印 100 以内的偶数</h1>
 * @package {me.shalling.threadTest}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/22 18:39
 */
public class ThreadExample extends Thread {
    private final static int FACTOR = 100;

    public ThreadExample(String threadName, int priority) {
        // 给线重写的类实例对象设置线程名称
        super(threadName);
        setPriority(priority);
    }

    public ThreadExample(String threadName) {
        // 给线重写的类实例对象设置线程名称
        super(threadName);
    }

    @Override
    public void run() {
        for (int i = 1; i <= FACTOR; ++i) {
            if (i % 2 == 0) {
                System.out.print(i + "\t");
            }
            if (i % 10 == 0) {
                System.out.println("=".repeat(3) + this.getName() + "=".repeat(3));
            }
        }
    }
}
