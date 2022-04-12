package JUCLearn.deadlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestDeadLock")
public class TestDeadLock {
    public static void main(String[] args) {
        test1();
    }
    private static void test1(){
        Object A = new Object();
        Object B = new Object();
        Thread t1 = new Thread(()->{
            synchronized (A){
                log.debug("lock A");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (B){
                        log.debug("lock B");
                        log.debug("操作...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            synchronized (B){
                log.debug("lock B ");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (A){
                        log.debug("lock A");
                        log.debug("操作...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
