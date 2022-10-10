package me.shalling;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>InetAddress Test</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/9 12:48
 */
public class InetAddressTest {
    @Test
    public void inetAddressTest() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(Arrays.toString(localHost.getAddress()));
            System.out.println(localHost.getHostName());
            System.out.println(localHost.getCanonicalHostName());
            System.out.println(localHost.getHostAddress());
            InetAddress host = InetAddress.getByName("www.bilibili.com");
            System.out.println(host.getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
