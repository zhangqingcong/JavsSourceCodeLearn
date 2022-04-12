package JUCLearn.Day01Test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestJoinTest")
public class TestJoinTest {
    static int r1 =0;
    static int r2=0;

    public static void main(String[] args) throws InterruptedException {

        test2();
    }
    public static void test2() throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                r1 = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                r2 = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        //注意 这里都是等待两秒 无论是先t2.join() 还是t1.join() 无论是单核还是双核
        t2.join();
        //注意这里 即使先等待t2运行结束，还要等t1结束，但是t2结束的时候 t1线程的的代码已经执行完毕了 给出结果了 不用在等待1秒了 线程join的时候会让出cpu
        //t2在等待2秒的期间 t1已经上cpu执行并且也等待了1s了 t1线程的代码已经执行完毕了 到
        t1.join();
        long end = System.currentTimeMillis();
        log.debug("r1:{} r2:{} cost: {}",r1,r2,end-start);

    }
}
