package me.shalling.threadTest;

import lombok.NoArgsConstructor;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>Runnable 实现 以及 synchronized 设置线程同步</h1>
 * @package {me.shalling.threadTest}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/25 8:31
 */
@NoArgsConstructor
public class RunnableExample implements Runnable {
  private final ReentrantLock locker = new ReentrantLock(true); // 有参构造器允许设置是否采用公平锁机制, 无参默认为非公平锁
  private Integer ticket = 100;
  private int threadTag = 1;

  public RunnableExample(int ticket) {
    this.ticket = ticket;
  }

  @Override
  public void run() {
    Thread.currentThread().setName("当前线程名称: " + threadTag++);
    while (true) {
      try {
        // 通过 ReentrantLock 的方式实现线程同步
        locker.lock();
        if (ticket < 1) {
          break;
        }
        System.out.println("当前线程: " + Thread.currentThread().getName() + " ticket: " + ticket--);
      } finally {
        locker.unlock();
      }
    }
  }
}
