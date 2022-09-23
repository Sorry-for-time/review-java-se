package me.shalling.linkLinearList;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling.linkLinearList}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/23 23:26
 */
public class LineLinearListTest {
    @Test
    public void linkLinearListTest() {
        LinkLinearList<String> stringLinkLinearList = new LinkLinearList<>(40);
        System.out.println(stringLinkLinearList.isEmpty() ? "当前列表为空" : "当前列表不为空");
        // 填充元素
        for (int i = 1; i < 36; ++i) {
            stringLinkLinearList.insertToList(String.valueOf(i), i);
        }
        // 更新节点的数据域
        stringLinkLinearList.updateItemByIndex("223", 1);
        stringLinkLinearList.updateItemByIndex("Wayne", 2);
        // 删除指定节位置的节点元素并打印
        System.out.println("被删除的元素: " + stringLinkLinearList.deleteItem(8));
        System.out.println("被删除的元素: " + stringLinkLinearList.deleteItem()); // 直接删除末尾元素
        System.out.println("=".repeat(23));
        stringLinkLinearList.insertToList("LIVE FREE OR DIE!"); // 直接插入尾元素
        // 调用顺序表的遍历方法
        stringLinkLinearList.forEach(new Consumer<>() {
            private static int wrapFlag = 1;

            @Override
            public void accept(String s) {
                System.out.print(s + "\t");
                // 换行输出
                if (wrapFlag % 10 == 0) {
                    System.out.println();
                }
                wrapFlag--;
            }
        });
        System.out.println();
        System.out.println("=".repeat(23));
        // 取得顺序表中的实际元素组成的数组
        System.out.println(Arrays.toString(stringLinkLinearList.getFactItems()));
    }
}
