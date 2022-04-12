package JUCLearn.Day01Test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.TestPark")
public class TestPark {
    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    //打断park线程 不会清空打断状态
    private static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
//            log.debug(" 打断状态：{}", Thread.currentThread().isInterrupted());
            log.debug(" 打断状态：{}", Thread.interrupted());


            LockSupport.park();
            log.debug("unpark...");
        }, "t1");
        t1.start();

        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
    }

    //如果打断标记已经是true 则park会失效 可以使用 Thread.interrupted() 清除打断状态
    private static void test4() throws InterruptedException {
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                log.debug("park...");
                LockSupport.park();
                log.debug(" 打断状态：{}", Thread.currentThread().isInterrupted());


            }
        }, "t4");
        t4.start();

        TimeUnit.SECONDS.sleep(1);
        t4.interrupt();
    }

}
