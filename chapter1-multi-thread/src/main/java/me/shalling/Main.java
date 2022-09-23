package me.shalling;

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
        new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + "\t");
                }
                if (i % 10 == 0) {
                    System.out.println();
                }
            }
            System.out.println("\n" + Thread.currentThread().getName());
        }, "self-define-thread-1").start();
    }
}