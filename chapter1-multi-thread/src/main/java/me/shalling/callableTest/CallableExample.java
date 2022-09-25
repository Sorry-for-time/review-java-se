package me.shalling.callableTest;

import java.util.concurrent.Callable;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>Callable 接口的使用</h1>
 * @package {me.shalling.callableTest}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/25 16:55
 */
public class CallableExample implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + "\t");
                sum += i;
            }
            if (i % 10 == 0) {
                System.out.println();
            }
        }
        return sum;
    }
}
