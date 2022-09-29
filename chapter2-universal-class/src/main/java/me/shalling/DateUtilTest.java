package me.shalling;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/28 19:58
 */
public class DateUtilTest {
    /**
     * @param source     初始字符串
     * @param beginIndex 截取起始位置
     * @param endIndex   截取终点位置
     * @return 反转后的字符串
     * @description 自定义字符串指定位置进行反转
     * @brief 截取起始位置从 0 开始, 左闭右开
     */
    public static String customizeReverse(String source, int beginIndex, int endIndex) {
        char[] chars = source.toCharArray();
        // 初始化存储空间
        char[] sliceStr = new char[endIndex - beginIndex];
        // 填充数组
        System.arraycopy(chars, beginIndex, sliceStr, 0, sliceStr.length);
        for (int i = beginIndex; i < endIndex; i++) {
            chars[i] = sliceStr[endIndex - i - 1];
        }
        return String.valueOf(chars);
    }

    @Test
    public void stringReverseTest() {
        String str = "HelloWorld";
        System.out.println(str.substring(1, 3)); // el
        String s = customizeReverse(str, 2, 5); // llo
        System.out.println(s); // HeollWorld
    }

    @Test
    public void simpleDateTest() {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("format result: " + simpleDateFormat.format(date));
        System.out.println(System.currentTimeMillis());
        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
    }

    /**
     * @description java8 新增时间日期 API
     */
    @Test
    public void newTimeApiTest() {
        LocalDateTime now = LocalDateTime.now(); // 获取当前日期 + 时间
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String format = dateTimeFormatter.format(now);
        System.out.println(format);

        String format1 = now.format(dateTimeFormatter);
        System.out.println(format1);
    }
}
