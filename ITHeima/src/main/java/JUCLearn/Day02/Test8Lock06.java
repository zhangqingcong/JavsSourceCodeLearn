package JUCLearn.Day02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 1秒后 1 2
 * 2 1秒后 1
 */
@Slf4j(topic = "c.Test8Lock06")
public class Test8Lock06 {
    public static void main(String[] args) {
        Number6 n1 = new Number6();
        new Thread(()->{
            log.debug("t1 begin");
            n1.a();
        },"t1").start();
        new Thread(()->{
            log.debug("t2 begin");
            n1.b();
        },"t2").start();
    }
}
@Slf4j(topic = "c.Number6")
class Number6{
    public static synchronized void a(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("1");
    }
    public static synchronized void b(){
        log.debug("2");
    }
}
