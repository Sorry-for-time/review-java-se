package me.shalling;

/**
 * @author Shalling
 * @version v0.01
 * @description <h1>the static factory test</h1>
 * @package {me.shalling}
 * @see <a href="https://github.com/Sorry-for-time">follow me on github</a>
 * @since 2022/10/14 9:25
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        SlaveWorker slaveWorker = new SlaveWorker();
        NiuMaFactory niuMaFactory = new NiuMaFactory(slaveWorker);
        niuMaFactory.run996();
    }
}

interface Factory996Work {
    void run996();
}

class NiuMaFactory implements Factory996Work {
    private final Factory996Work veryCheapWork;

    public NiuMaFactory(Factory996Work veryCheapWork) {
        this.veryCheapWork = veryCheapWork;
    }

    @Override
    public void run996() {
        System.out.println("cheap worker is not a person, just run out before die");
        veryCheapWork.run996();
        System.out.println("OK, the cheap work can fire");
    }
}

class SlaveWorker implements Factory996Work {
    @Override
    public void run996() {
        System.out.println("Oh, the holly shit work is beginning!");
    }
}

