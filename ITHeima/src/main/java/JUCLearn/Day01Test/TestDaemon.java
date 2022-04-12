package JUCLearn.Day01Test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestDaemon")
public class TestDaemon {
    public static void main(String[] args) throws InterruptedException {
        log.debug("开始运行...");
        Thread t1 = new Thread(()->{
            log.debug("开始运行。。。");
            try {
                TimeUnit.SECONDS.sleep(2);
                log.debug("运行结束...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t1.setDaemon(true);
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        log.debug("运行结束...");
    }

}
