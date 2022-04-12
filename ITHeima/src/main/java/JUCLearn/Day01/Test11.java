package JUCLearn.Day01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test11")
public class Test11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.debug("sleep...");
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"t1");

        t1.start();
        TimeUnit.SECONDS.sleep(1);
        log.debug("interrupt");
        t1.interrupt();
        log.debug("打断标记：{}",t1.isInterrupted());
    }
}
