import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

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

    /**
     * @description 测试 TreeMap 的内置方法
     */
    @Test
    public void map2Test() {
        // 允许传入一个 Comparator 对象实现定制排序(无参默认为自然排序)
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> -o1.compareTo(o2));
        treeMap.put(2, 2);
        treeMap.put(1, 1);
        treeMap.put(3, 3);
        System.out.println("-".repeat(11) + "forEach" + "-".repeat(11));
        treeMap.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        Set<Map.Entry<Integer, Integer>> entries = treeMap.entrySet();
        System.out.println("-".repeat(11) + "entries" + "-".repeat(11));
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    /**
     * @description Properties key-value 均为 String 类型, 通常用来处理配置文件
     */
    @Test
    public void map3Test() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/JDBC.properties")) {
            properties.load(fileInputStream);
            properties.forEach((k, v) -> System.out.println(k + ": " + v));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @description Collections 工具类部分方法的使用
     */
    @Test
    public void collectionsMethodTest() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add((int) (Math.random() * 100));
        }
        System.out.println("-".repeat(11) + "raw values" + "-".repeat(11));
        System.out.println(integers);
        // 就地排序
        System.out.println("-".repeat(11) + "sort1" + "-".repeat(11));
        Collections.sort(integers);
        System.out.println(integers);
        // 传入自定义比较器
        System.out.println("-".repeat(11) + "sort2" + "-".repeat(11));
        Collections.sort(integers, (o1, o2) -> -Integer.compare(o1, o2));
        System.out.println(integers);
        System.out.println("-".repeat(11) + "shuffle" + "-".repeat(11));
        Collections.shuffle(integers);
        System.out.println(integers);
        System.out.println("-".repeat(11) + "reverse" + "-".repeat(11));
        Collections.reverse(integers);
        System.out.println(integers);
        System.out.println("-".repeat(11) + "stringHashMap" + "-".repeat(11));
        HashMap<String, String> stringHashMap = new HashMap<>();
        for (int i = 1; i <= 10; ++i) {
            stringHashMap.put(String.valueOf(i), String.valueOf(i));
        }
        System.out.println(stringHashMap);
        System.out.println("=".repeat(24));
        var list = Arrays.asList(new String[10]);
        System.out.println(list);
        // 复制操作, 要求 dest 的 size 不能小于 src 的 size
        Collections.copy(list, stringHashMap.values().stream().toList());
        System.out.println(list);
        // 取得线程安全的集合
        List<String> synchronizedList = Collections.synchronizedList(list);
        // 取得线程安全的 map
        Map<String, String> stringStringMap = Collections.synchronizedMap(stringHashMap);
        System.out.println("-".repeat(24));
        System.out.println(synchronizedList);
        System.out.println(stringStringMap);
    }
}
