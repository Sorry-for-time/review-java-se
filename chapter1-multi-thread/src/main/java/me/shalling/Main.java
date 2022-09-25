package me.shalling;

import me.shalling.threadTest.RunnableExample;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/25 8:58
 */
public class Main {
    public static void main(String[] args) {
        RunnableExample runnableExample = new RunnableExample(30);
        Thread thread = new Thread(runnableExample);
        Thread thread1 = new Thread(runnableExample);
        Thread thread2 = new Thread(runnableExample);
        Thread thread3 = new Thread(runnableExample);
        Thread thread4 = new Thread(runnableExample);
        Thread thread5 = new Thread(runnableExample);
        Thread thread6 = new Thread(runnableExample);
        Thread thread7 = new Thread(runnableExample);
        {
            thread.start();
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            thread6.start();
            thread7.start();
        }
    }
}
