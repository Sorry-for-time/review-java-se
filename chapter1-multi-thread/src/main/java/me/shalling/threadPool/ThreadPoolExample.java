package me.shalling.threadPool;

import java.util.concurrent.*;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.threadPool}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/25 19:21
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        // 创建一个线程池
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(12);
        // 允许设置一些配置
        executorService.allowsCoreThreadTimeOut();
        executorService.setMaximumPoolSize(344);
        executorService.setKeepAliveTime(1000, TimeUnit.HOURS);
        // submit 适用于 Runnable 和 Callable
        executorService.submit(() -> System.out.println("Runnable->1"));
        try {
            System.out.println(executorService.submit((Callable<Object>) () -> {
                System.out.println("Callable->2");
                return "return str is: Callable";
            }).get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        // execute 适用于  Runnable
        executorService.execute(() -> System.out.println("Runnable->3"));
        // 销毁线程池
        executorService.shutdown();
    }
}
