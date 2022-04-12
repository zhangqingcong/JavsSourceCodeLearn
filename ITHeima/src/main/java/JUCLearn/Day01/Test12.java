package JUCLearn.Day01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test12")
public class Test12 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted){//打断标记的用途，当线程被打断的时候，线程可以自己决定是否退出执行
                    log.debug("被打断了，推出循环");
                    break;
                }
            }
        },"t1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        log.debug("interrupt");
        t1.interrupt();
    }
}
