package me.shalling;

import java.util.ArrayList;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>write comment here</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/5 15:53
 */
public class Generic3Test {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        System.out.println(stringArrayList.getClass().getName());
        System.out.println(integerArrayList.getClass().getName());
        System.out.println(integerArrayList.getClass() == integerArrayList.getClass()); // true
    }
}
