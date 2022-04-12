package JUCLearn.deadlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

public class TestDeadLock01 {
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");
        new Philosopher("苏格拉底",c1,c2).start();
        new Philosopher("柏拉图",c2,c3).start();
        new Philosopher("亚里士多德",c3,c4).start();
        new Philosopher("赫拉克利特",c4,c5).start();
//        new Philosopher("阿基米德 ",c5,c1).start();
        new Philosopher("阿基米德 ",c1,c5).start();
    }

}
@Slf4j(topic = "c.Philosopher")
class Philosopher extends Thread{
    Chopstick left;
    Chopstick right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true){
            //尝试获得左手筷子
            synchronized (left){
                //尝试获得右手筷子
                synchronized (right){
                    eat();
                }
            }
        }
    }

    private void eat(){
        log.debug("eating...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//这里的筷子可以抽象成系统中需要共享的资源
class Chopstick{
    String name;

    public Chopstick(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chopstick{" +
                "name='" + name + '\'' +
                '}';
    }
}
