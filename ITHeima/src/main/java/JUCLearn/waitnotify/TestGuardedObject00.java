package JUCLearn.waitnotify;

import JUCLearn.Downloader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j(topic = "c.TestGuardedObject00")
public class TestGuardedObject00 {
    //线程1 等待 线程2 的下载结果
    public static void main(String[] args) {
        GuardedObject00 guardedObject00 = new GuardedObject00();
        new Thread(()->{
            log.debug("等待结果");
            List<String> list = (List<String>) guardedObject00.get();
            log.debug("结果大小：{}",list.size());

        },"t1").start();

        new Thread(()->{
            log.debug("执行下载");
            try {
                List<String> list = Downloader.download();
                guardedObject00.complete(list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}

class GuardedObject00{
    //一个线程需要等待另外一个线程产生的结果
    private Object response;

    //这个方法产生结果
    public void complete(Object response){
        synchronized (this){
            this.response = response;
            /**
             * 结果产生以后 就唤醒所有等待的队列
             * notifyAll()方法必须和synchronized关键字配合使用
             */
            this.notifyAll();
        }
    }

    //获取结果的方法 无参代表一直等待到获得结果
    public Object get(){
        synchronized(this){
            //如果结果为空 就一直等待 使用while一直判断 防止虚假唤醒 用if的话判断一次如果没获得参数就不执行了
            while (response == null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //走到这里说明获得结果了 不用wait了
        return response;
    }

    /**
     * 带参数表示最多就等这么久 如果还没出就不等了
     * @param timeout
     * @return
     */
    public Object get(long timeout){
        synchronized (this){
            //第一次进入循环前 开始等待的时间
            long begin = System.currentTimeMillis();
            //等待了多长时间 第一次进入循环前是0 说明还没开始等待
            long passTime = 0;
            while (response == null){
                //每次循环开始的时候 总共需要等待的时间-已经等待的时间
                long waitTime = timeout -passTime;
                //还要等的时间<=0了说明不用等待了
                if (waitTime<=0){
                    break;//跳出循环
                }
                try {
                    this.wait(timeout);//这里用参数timeout是不行的 如果这个线程被虚假唤醒了 但是还没等够时间 退出后又回到了这里 就需要在等待time-out这么久的时间了
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //循环一轮后 这一轮循环等了多长时间
               passTime = System.currentTimeMillis()-begin;
            }
        }
        return response;
    }
}
