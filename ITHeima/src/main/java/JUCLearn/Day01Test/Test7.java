package JUCLearn.Day01Test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test7")
public class Test7 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    log.debug("wake up ...");
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
            log.debug("interrupted...");
            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
