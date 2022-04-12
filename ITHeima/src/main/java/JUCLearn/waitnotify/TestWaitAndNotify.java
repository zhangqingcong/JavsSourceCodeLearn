package JUCLearn.waitnotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestWaitAndNotify")
public class TestWaitAndNotify {
    final static Object obj = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized(obj){
                log.debug("t1...");
                try {
                    obj.wait();//让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("t1其他代码。。。");
            }

        },"t1").start();

        new Thread(()->{
            synchronized (obj){
                log.debug("t2...");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("t2其他代码...");
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("唤醒等待obj锁的其他线程");
        synchronized (obj){
//            obj.notify();//随机唤醒一个等待obj锁的线程
            obj.notifyAll();//唤醒所有
        }
    }
}
