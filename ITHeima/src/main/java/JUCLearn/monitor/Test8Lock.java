package JUCLearn.monitor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test8Lock")
public class Test8Lock {
    public static void main(String[] args) {
        Number n = new Number();


        new Thread(() -> {
            log.debug("开始");
            try {
                n.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();


        new Thread(() -> {
            log.debug("开始");
            n.b();
        }, "t2").start();
    }
}

@Slf4j(topic = "c.Number")
class Number {
    public synchronized void a() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.debug("1");
    }

    public synchronized void b() {
        log.debug("2");
    }
}