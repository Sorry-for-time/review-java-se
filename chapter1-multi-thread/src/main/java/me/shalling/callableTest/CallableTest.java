package me.shalling.callableTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.callableTest}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/25 16:58
 */
public class CallableTest {
    public static void main(String[] args) {
        CallableExample callableExample = new CallableExample();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(callableExample);
        Thread thread = new Thread(integerFutureTask, "一个没感情的输出偶数的线程");
        thread.start();
        System.out.println();
        try {
            Integer result = integerFutureTask.get();
            System.out.println("sum = " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
