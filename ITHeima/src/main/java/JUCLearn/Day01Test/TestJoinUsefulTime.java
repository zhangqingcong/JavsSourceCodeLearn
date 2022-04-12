package JUCLearn.Day01Test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
@Slf4j(topic = "c.TestJoinUsefulTime")
public class TestJoinUsefulTime {
    static int r1 = 0;
    static int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
    test3();
    }
    public static void test3() throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
//                TimeUnit.SECONDS.sleep(1);
                r1 = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long start = System.currentTimeMillis();
        t1.start();
        //线程执行结束会导致join结束 join(long n)有时限的等待 只会等n秒 即使t1线程没结束 也会停止等待 继续执行
        t1.join(1500);
        long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} cost: {}",r1,r2,end-start);
    }
}
