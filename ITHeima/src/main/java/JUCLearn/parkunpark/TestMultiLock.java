package JUCLearn.parkunpark;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

public class TestMultiLock {
    public static void main(String[] args) {
        BigRoom bigRoom = new BigRoom();
        new Thread(()->{
            bigRoom.study();
        },"小南").start();

        new Thread(()->{
            bigRoom.sleep();
        },"小女 ").start();
    }
}
@Slf4j(topic = "c.BigRoom")
class BigRoom{

    public void sleep(){
        synchronized (this){
            log.debug("sleeping 2 小时");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void study(){
        synchronized (this){
            log.debug("study 1 小时");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
