package me.shalling.linearList;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.linearList}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/23 21:17
 */
public class LinearListTest {
    @Test
    public void linearListTest() {
        LinearList<String> stringLinearList = new LinearList<>(50);
        System.out.println("当前顺序表是否为空: " + (stringLinearList.isEmpty() ? "是" : "否"));
        // 批量插入一波没有感情的测试数据
        for (int start = 1; start <= 10; start++) {
            stringLinearList.insertToList(String.valueOf(start), start);
        }
        // 在指定位置上插入元素
        stringLinearList.insertToList("233", 1);
        // 分割线
        System.out.println("=".repeat(10) + "分割线" + "=".repeat(10));
        // 随机删除一个元素, 并查看下删除的元素
        System.out.println("删除的元素: " + stringLinearList.deleteItem(3));
        stringLinearList.updateItemByIndex("咦?", 7);
        // 调用遍历: 这里传入一个消费者实例
        System.out.println("遍历输出结果如下:");
        stringLinearList.forEach(new Consumer<>() {
            /**
             * @description 用于记录当遍历的位置
             */
            private static int wrapFlag = 1;

            @Override
            public void accept(String s) {
                System.out.print("|" + s + "\t");
                // 每 输出 10 个进行换行
                if (wrapFlag % 10 == 0) {
                    System.out.println("|");
                    System.out.println();
                }
                wrapFlag++;
            }
        });
        System.out.println("=".repeat(10) + "分割线" + "=".repeat(10));
        System.out.println("取得 buffer 中的实际元素: " + Arrays.toString(stringLinearList.getFactItems()));
    }
}
