package JUCLearn.waitnotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.LimitWait")
public class LimitWait {
    final static Object obj = new Object();
    public static void main(String[] args) {

        new Thread(()->{
            synchronized(obj){
                log.debug("开始");
                try {
                    obj.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("end");
            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("唤醒obj上其他代码");
        synchronized(obj){
            obj.notifyAll();
        }
    }
}
