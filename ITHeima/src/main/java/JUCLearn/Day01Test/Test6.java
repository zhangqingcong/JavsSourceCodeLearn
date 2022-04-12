package JUCLearn.Day01Test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test6")
public class Test6 {
    public static void main(String[] args) {
        /**
         * 创建线程对象
         * Thread t = new Thread(){
         *     要执行的任务
         * }
         * 启动线程
         * t.start();
         */
        //构造方法的参数是给线程指定名称
        Thread t1 = new Thread("t1"){
            //run方法内实现了要执行的任务
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        log.debug("t1 线程的状态：{}",t1.getState());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("t1 线程的状态：{}",t1.getState());
    }
}
