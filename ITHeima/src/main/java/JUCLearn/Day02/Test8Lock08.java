package JUCLearn.Day02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 第8种情况
 * 1秒后 12
 *17:05:41 [t1] c.Test8Lock08 - t1 begin
 * 17:05:41 [t2] c.Test8Lock08 - t2 begin
 * 17:05:42 [t1] c.Number8 - 1
 * 17:05:42 [t2] c.Number8 - 2
 *
 * 2 1秒后 1
 * 17:04:36 [t2] c.Test8Lock08 - t2 begin
 * 17:04:36 [t2] c.Number8 - 2
 * 17:04:36 [t1] c.Test8Lock08 - t1 begin
 * 17:04:37 [t1] c.Number8 - 1
 */
@Slf4j(topic = "c.Test8Lock08")
public class Test8Lock08 {
    public static void main(String[] args) {
        Number8 n1 = new Number8();
        Number8 n2 = new Number8();
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


@Slf4j(topic = "c.Number8")
class Number8{
//    public static synchronized void a(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.debug("1");
//    }

    //上面的代码等价于
    public static void a(){
        synchronized (Number8.class){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("1");
        }
    }

//    public static synchronized void b(){
//        log.debug("2");
//    }

    //上面的代码等价于
    public static void b(){
        synchronized (Number8.class){
            log.debug("2");
        }
    }
}