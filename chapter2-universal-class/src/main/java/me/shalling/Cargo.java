package me.shalling;

import lombok.Getter;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>实现 Comparable 接口测试</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/9/29 16:04
 */
public class Cargo implements Comparable<Cargo> {
    @Getter
    private String name;

    @Getter
    private double price;

    public Cargo() {
    }

    public Cargo(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * @param o the object to be compared.
     * @return 1 || -1 || 0
     */
    @Override
    public int compareTo(Cargo o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.price < o.price) {
            return -1;
        } else {
            return this.name.compareTo(o.getName());
        }
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
