package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since ${DATE} ${TIME}
 */
public class MapBuiltInMethodsTest {
    /**
     * @description 测试 HashMap 的常用方法
     */
    @Test
    public void map1Test() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("1", "1");
        stringStringHashMap.put("2", "2");
        var receive = stringStringHashMap.put("3", "3");
        System.out.println("=> " + receive);
        System.out.println("-".repeat(11) + "containsValue && containsKey" + "-".repeat(11));
        System.out.println(stringStringHashMap.containsKey("1"));
        System.out.println(stringStringHashMap.containsValue("1"));
        System.out.println("-".repeat(11) + "entrySet" + "-".repeat(11));
        for (Map.Entry<String, String> entry : stringStringHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("-".repeat(11) + "forEach" + "-".repeat(11));
        stringStringHashMap.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        System.out.println("-".repeat(11) + "values" + "-".repeat(11));
        stringStringHashMap.values().forEach(v -> {
            System.out.print(v + "\t");
        });
        System.out.println();
        System.out.println("-".repeat(11) + "keySet" + "-".repeat(11));
        stringStringHashMap.keySet().forEach(k -> {
            System.out.print(k + "\t");
        });
    }
}
