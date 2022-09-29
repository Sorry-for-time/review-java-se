package me.shalling;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>排序测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/29 16:09
 */
public class CompareTest {
    @Test
    public void comparable1Test() {
        Cargo[] cargos = new Cargo[5];
        cargos[0] = new Cargo("Huawei", 34);
        cargos[1] = new Cargo("Xiaomi", 23);
        cargos[2] = new Cargo("Lenovo", 45);
        cargos[3] = new Cargo("Index", 33);
        cargos[4] = new Cargo("Honor", 33);
        Arrays.sort(cargos);
        System.out.println(Arrays.toString(cargos));
    }

    @Test
    public void comparatorTest() {
        Cargo[] cargos2 = new Cargo[5];
        cargos2[0] = new Cargo("Huawei", 34);
        cargos2[1] = new Cargo("Xiaomi", 23);
        cargos2[2] = new Cargo("Lenovo", 45);
        cargos2[3] = new Cargo("Index", 33);
        cargos2[4] = new Cargo("Honor", 33);
        Arrays.sort(cargos2, (o1, o2) -> {
            // 降序排序
            return -Double.compare(o1.getPrice(), o2.getPrice());
        });
        System.out.println(Arrays.toString(cargos2));
    }
}
