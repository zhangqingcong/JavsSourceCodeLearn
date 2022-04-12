package JUCLearn.Day02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 锁的不是同一个对象 总是先2 1秒后1
 * 16:54:55 [t1] c.Test8Lock07 - t1 begin
 * 16:54:55 [t2] c.Test8Lock07 - t2 begin
 * 16:54:55 [t2] c.Number7 - 2
 * 16:54:56 [t1] c.Number7 - 1
 *
 */
@Slf4j(topic = "c.Test8Lock07")
public class Test8Lock07 {
    public static void main(String[] args) {
        Number7 n1 = new Number7();
        Number7 n2 = new Number7();
        new Thread(()->{
            log.debug("t1 begin");
            n1.a();
        },"t1").start();
        new Thread(()->{
            log.debug("t2 begin");
            n2.b();
        },"t2").start();
     }
}

@Slf4j(topic = "c.Number7")
class Number7{

    public static synchronized void a(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("1");
    }

    public synchronized void b(){
        log.debug("2");
    }
}
