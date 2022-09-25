package me.shalling.threadTest;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.threadTest}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/25 8:31
 */
public class RunnableTest implements Runnable {
    private int ticket = 100;
    private int threadTag = 1;

    @Override
    public void run() {
        Thread.currentThread().setName("当前线程名称: " + threadTag++);
        while (ticket > 0) {
            System.out.println("当前线程" + ticket--);
        }
    }
}
