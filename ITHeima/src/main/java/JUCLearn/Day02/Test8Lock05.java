package JUCLearn.Day02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 情况5 锁住的不是同一个对象 先2 1秒后 1
 */
@Slf4j(topic = "c.Test8Lock05")
public class Test8Lock05 {

    public static void main(String[] args) {
        Number5 n1 = new Number5();
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
@Slf4j(topic = "c.Number5")
class Number5{
//    public static synchronized void a(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.debug("1");
//    }
    //下面的代码等价于上面
    public static  void a(){
        synchronized (Number5.class){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("1");
        }
    }

    public synchronized void b(){
        log.debug("2");
    }

}
