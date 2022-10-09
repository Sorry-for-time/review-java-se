package me.shalling;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>用于进行序列化测试写入的类</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/8 22:33
 */
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 4081662533606594180L;

    private String name;
    private int age;
    private boolean sex;

    public User() {
    }

    public User(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (age != user.age) return false;
        if (sex != user.sex) return false;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + (sex ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
