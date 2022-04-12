package JUCLearn.waitnotify;

import lombok.extern.slf4j.Slf4j;
/**
 * sleep(long n)和wait(long n)的区别
 * 1、sleep是Thread类的静态方法。wait是Object类的方法
 * 2、sleep不需要强制和synchronized配合使用。wait需要和synchronized一起使用
 * 3、sleep在睡眠的同时不释放对象锁。wait在等待的时候释放锁
 *
 * 相同
 * 1、sleep和wait状态都是TIMED_WAITING
 * 2、都会让出cpu使用
 */
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.SleepAndWait")
public class SleepAndWait {
    static final Object lock = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock){
                log.debug("获得锁");
                try {
//                    Thread.sleep(5000);
                    lock.wait();//进入阻塞队列 就释放所拥有的锁资源
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){
            log.debug("主线程获得锁");
        }
    }
}
