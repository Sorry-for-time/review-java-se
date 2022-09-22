package me.shalling;

import me.shalling.threadTest.ThreadExample;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>test thread && start()</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample("thread-1", 8);
        ThreadExample t2 = new ThreadExample("thread-2");
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}