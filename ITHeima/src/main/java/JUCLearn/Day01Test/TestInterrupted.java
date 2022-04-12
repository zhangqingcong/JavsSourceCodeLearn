package JUCLearn.Day01Test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 打断标记 如果被打断过 就是true 如果没有打断过 就是false
 */
@Slf4j(topic = "c.TestInterrupted")
public class TestInterrupted {
    public static void main(String[] args) throws InterruptedException {
        //sleep wait join方法都会使线程进入阻塞状态
        test2();

    }
    //打断正在sleep的线程
    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t1.start();
        TimeUnit.SECONDS.sleep((long) 0.5);
        t1.interrupt();
        //打断sleep状态的线程 会清空线程状态
        log.debug("打断状态：{}",t1.isInterrupted());
    }
    //打断正常运行的线程
    private static void test2() throws InterruptedException {
        Thread t2 = new Thread(()->{
            while (true){
                Thread thread = Thread.currentThread();
                boolean interrupted = thread.isInterrupted();
                if (interrupted){
                    log.debug(" 打断状态：{}",interrupted);
                    break;
                }
            }
        },"t2");
        t2.start();

        TimeUnit.SECONDS.sleep((long) 0.5);
        t2.interrupt();
    }
}
