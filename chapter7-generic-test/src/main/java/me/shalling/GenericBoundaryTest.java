package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>泛型范围测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/5 11:08
 */
public class GenericBoundaryTest {
    /**
     * @param list 进行遍历的数组
     * @brief 只允许范围为 Integer 和 Integer 的子类引用的调用, 即范围 <= Integer
     * @brief 适合于频繁的读操作
     */
    @SuppressWarnings("WhileLoopReplaceableByForEach")
    public void genericExtendsNumberTest(List<? extends Number> list) {
        Iterator<? extends Number> iterator = list.iterator();
        while (iterator.hasNext()) {
            Number next = iterator.next();
            System.out.print(next + "\t");
        }
    }

    /**
     * @param list 等待遍历的列表
     * @brief 只允许泛型为 Integer 及 Integer 的父类引用调用, 即范围 >= Integer, 可以是 Number, Object
     * @brief super 适合于频频繁的写操作
     */
    @SuppressWarnings("WhileLoopReplaceableByForEach")
    public void genericSuperNumberTest(List<? super Number> list) {
        Iterator<? super Number> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.print(next + "\t");
        }
    }

    @Test
    public void genericBoundaryTest() {
        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            integerList.add(i);
            numberList.add(i);
            doubleList.add((double) i);
            objectList.add(i);
        }
        genericExtendsNumberTest(numberList); // OK,
        System.out.println();
        genericExtendsNumberTest(integerList); // OK, Integer 属于 Number 的子类, 范围小于 Number
        System.out.println();
        genericExtendsNumberTest(doubleList); // OK, Double 属于 Number 的子类, 范围小于 Number
        System.out.println();
        // ===================================================================================
        genericSuperNumberTest(numberList); // OK
        System.out.println();
        genericSuperNumberTest(objectList); // OK, Object 是 Number 父类
        // genericSuperNumberTest(doubleList); // 编译检查不通过, 要求范围大于 Number
        // genericSuperNumberTest(integerList); // 编译检查不通过, 要求范围大于 Number
    }
}
