package JUCLearn.Day01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test10")

public class Test10 {
    static int r = 0;
    public static void main(String[] args) throws InterruptedException {
        test1();
    }
    private static void test1() throws InterruptedException{
        log.debug("开始");
        Thread t1 = new Thread(()->{
            log.debug("开始");
            try {
                TimeUnit.SECONDS.sleep(1);
                r = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
        },"t1");
        t1.start();
//        TimeUnit.SECONDS.sleep(3);
        t1.join();//在main线程里面调用t1线程的join方法 代表main线程要等t1线程执行完毕在执行
        log.debug("结果为：{}",r);//t1线程休眠了1秒 CPU让给了main线程 所以r=0 可以尝试让main也休眠 但是不一定能保证
        log.debug("结束");
    }
}
