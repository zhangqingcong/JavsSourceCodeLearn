package JUCLearn.Day01Test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test9Join")
public class Test9Join {
    static int r = 0;

    public static void main(String[] args) throws InterruptedException {
    test1();
    }

    private static void test1() throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            try {
                log.debug("开始");
                TimeUnit.SECONDS.sleep(1);
                log.debug("结束");
                r = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t1.start();
        //等t1线程运行结束以后在运行 不加r=0 加了 r=10
        t1.join();
        log.debug("结果为:{}",r);
        log.debug("结束");
    }
}
