package JUCLearn.parkunpark;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.TestParkUnpark")
public class TestParkUnpark {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            log.debug("start...");
            try {
                TimeUnit.SECONDS.sleep(1);
                log.debug("park...");
                LockSupport.park();
                log.debug("resume...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t1.start();


        try {
//            TimeUnit.SECONDS.sleep(2);
            TimeUnit.SECONDS.sleep(1);
            log.debug("unpark...");
            LockSupport.unpark(t1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
