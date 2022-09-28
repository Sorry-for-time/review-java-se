package me.shalling;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
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
    @Test
    public void simpleDateTest() {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("format result: " + simpleDateFormat.format(date));
        System.out.println(System.currentTimeMillis());
        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
    }
}
