package me.shalling.threadTest;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.threadTest}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/25 15:57
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Consumer consumer1 = new Consumer(clerk, "消费者1 ->");
        Consumer consumer2 = new Consumer(clerk, "消费者2 ->");
        Producer producer1 = new Producer(clerk, "生产者1 ->");
        Producer producer2 = new Producer(clerk, "生产者2 ->");
        consumer1.start();
        consumer2.start();
        producer1.start();
        producer2.start();
    }
}

class Clerk {
    private Integer cargoCounts = 0;

    public void produce() {
        while (true) {
            synchronized (this) {
                if (cargoCounts < 20) {
                    System.out.println(Thread.currentThread().getName() + " 生产第: " + (++cargoCounts) + " 件");
                    notify(); // 唤醒消费者
                } else {
                    try {
                        wait(); // 释放资源锁
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public void consume() {
        while (true) {
            synchronized (this) {
                if (cargoCounts > 0) {
                    System.out.println(Thread.currentThread().getName() + "消费第: " + (this.cargoCounts--) + " 件");
                    notify(); // 唤醒生产者 --> 根据优先级进行唤醒
                } else {
                    try {
                        wait(); // 释放当前线程同步锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Consumer extends Thread {
    private final Clerk clerk;

    public Consumer(Clerk clerk, String threadName) {
        this.clerk = clerk;
        setName(threadName);
    }

    @Override
    public void run() {
        clerk.consume();
    }
}

class Producer extends Thread {
    private final Clerk clerk;

    public Producer(Clerk clerk, String threadName) {
        setName(threadName);
        this.clerk = clerk;
    }

    @Override
    public void run() {
        clerk.produce();
    }
}
