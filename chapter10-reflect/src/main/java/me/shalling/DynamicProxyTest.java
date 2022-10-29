package me.shalling;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description 测试类的父接口
 */
interface Creature {
  void showEager();
}

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>动态代理测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/14 21:25
 */
public class DynamicProxyTest {
  @Test
  public void dynamicProxyTest() {
    Creature proxyInstance = (Creature) ProxyFactory.getProxyInstance(new Human());
    proxyInstance.showEager();
  }
}

final class AOPDemoHint {
  public static void justRunAtBefore() {
    System.out.println("很无聊的一个方法1 --> before");
  }

  public static void justRunAtAfter() {
    System.out.println("很无聊的一个方法2 --> after");
  }
}

/**
 * @description 测试类
 */
class Human implements Creature {
  @Override
  public void showEager() {
    System.out.println("JUST WANT LIFE RUN AND GO");
  }
}

/**
 * @description 自定义 InvocationHandler 实现类
 */
final class MyInvocationHandler implements InvocationHandler {
  private final Object originTarget;

  public MyInvocationHandler(Object originTarget) {
    this.originTarget = originTarget;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // 注: invoke 方法需要取得原始的被代理类对象
    // -> 为切面编程提供了条件
    // 假设这是 before 操作
    AOPDemoHint.justRunAtBefore();
    Object returnValue = method.invoke(this.originTarget, args);
    // 假设这是 after 操作
    AOPDemoHint.justRunAtAfter();
    return returnValue;
  }
}

final class ProxyFactory {
  public static Object getProxyInstance(Object origin) {
    final InvocationHandler invocationHandler = new MyInvocationHandler(origin);
    /*
     * 在通过代理类对象执行被代理类对象的方法时, 会通过传入的实现 InvocationHandler 接口对象的 invoke 方法
     * 执行被代理类的对应方法, 并返回对应的值 -> 内部依然通过 invoke(被代理类对象, 参数)的形式来实现方法调用
     **/
    return Proxy
      .newProxyInstance(
        origin
          .getClass()
          .getClassLoader(), /* 取得类加载器 */
        origin
          .getClass()
          .getInterfaces(), /* 取得类的接口类型 */
        invocationHandler /* 具体的执行器 */
      );
  }
}
