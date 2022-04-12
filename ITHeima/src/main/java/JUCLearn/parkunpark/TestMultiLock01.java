package JUCLearn.parkunpark;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestMultiLock01")
public class TestMultiLock01 {
    public static void main(String[] args) {
        BigRoom1 bigRoom1 = new BigRoom1();
        new Thread(()->{
            try {
                bigRoom1.study();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小南").start();

        new Thread(()->{
            try {
                bigRoom1.sleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小女").start();

    }
}
@Slf4j(topic = "c.BigRoom1")
class BigRoom1{
    private final Object studyRoom = new Object();
    private final Object bedRoom = new Object();

    public void sleep() throws InterruptedException {
        synchronized (bedRoom){
            log.debug("sleep 2 hours");
            TimeUnit.SECONDS.sleep(2);
        }
    }

    public void study() throws InterruptedException {
        synchronized (studyRoom){
            log.debug("study 1 hour");
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
