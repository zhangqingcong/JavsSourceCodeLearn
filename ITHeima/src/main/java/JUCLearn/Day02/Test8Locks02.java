package JUCLearn.Day02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 情况4 应为锁定的不是同一个对象 所以总是同时启动
 * 先2 然后1秒后 1
 */
@Slf4j(topic = "c.Test8Locks02")
public class Test8Locks02 {
    public static void main(String[] args) {
        Number1 n1 = new Number1();
        Number1 n2 = new Number1();

        new Thread(()->{
            try {
                log.debug("begin");
                n1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            log.debug("begin");
            n2.b();
        },"t2").start();
    }

}

@Slf4j(topic = "c.Number1")
class Number1{
//    public synchronized void a() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(1);
//        log.debug("1");
//    }

    //上面的代码等价于
    public void a() throws InterruptedException {
        synchronized(this){
            TimeUnit.SECONDS.sleep(1);
            log.debug("1");
        }
    }

//    public synchronized void b(){
//        log.debug("2");
//    }

    //上面的代码等价于
    public void b(){
        synchronized (this){
        log.debug("2");
        }
    }

}
