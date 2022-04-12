package JUCLearn.monitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test1")
public class Test1 {
    static int count = 0;
    static final Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (o) {
                    count++;
                }
            }

        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (o){
                    count--;
            }}
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("count {} ", count);
    }
}
