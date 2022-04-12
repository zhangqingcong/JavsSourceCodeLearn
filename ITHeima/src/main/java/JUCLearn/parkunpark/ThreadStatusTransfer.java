package JUCLearn.parkunpark;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.ThreadStatusTransfer")
public class ThreadStatusTransfer {
    final static Object obj = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (obj){
                log.debug("执行。。。");
                try {
                    obj.wait();//让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码");
            }
        },"t1").start();

        new Thread(()->{
            synchronized (obj){
                log.debug("执行...");
                try {
                    obj.wait();//让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码...");
            }
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("唤醒obj上其他线程");
        synchronized (obj){
            obj.notifyAll();
        }
    }
}
