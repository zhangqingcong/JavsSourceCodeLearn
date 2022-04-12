package JUCLearn.deadlock;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestLiveLock")
public class TestLiveLock {
    static volatile int count =10;
    static final Object lock = new Object();

    public static void main(String[] args) {

        new Thread(()->{
            while (count >0){
                try {
                    Thread.sleep(200);
                    count -- ;
                    log.debug("count:{}",count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            while (count<20){
                try {
                    Thread.sleep(200);
                    count++;
                    log.debug("count:{}",count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();
    }
}
