package JUCLearn.waitnotify;

import JUCLearn.Downloader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j(topic = "c.TestGuardedObject")
public class TestGuardedObject {
    //线程1 等待 线程2 的下载结果
    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
        new Thread(() -> {
            //等待结果
            log.debug("等待结果");
            List<String> list = (List<String>) guardedObject.get();
            log.debug("结果大小：{}", list.size());
        }, "t1").start();

        new Thread(() -> {
            log.debug("执行下载");
            try {
                List<String> list = Downloader.download();
                guardedObject.complete(list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }

}

class GuardedObject {
    //结果
    private Object response;

    //产生结果
    public void complete(Object response) {
        synchronized (this) {
            //给结果成员变量赋值
            this.response = response;
            this.notifyAll();
        }
    }

    //获取结果
    public Object get() {
        //没有结果的时候，使用while循环 防止虚假唤醒
        synchronized (this) {
            while (response == null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    //获取结果
    //timeout表示要等待多久
    public Object get(long timeout) {
        //没有结果的时候，使用while循环 防止虚假唤醒
        synchronized (this) {
            //开始等待的时间 例如是 9：00：00开始的
            long begin = System.currentTimeMillis();
            //等待经历的时间 还没进入循环 所以经过时间是0
            long passTime = 0;
            while (response == null) {
                //这一轮应该等待的时间
                long waitTime = timeout - passTime;
                //循环等待的时间超过了最大等待时间，退出循环 如果passTime>=timeout也就是说已经等待了2秒了 需要break退出循环
//                if (passTime>=timeout){
//                    break;
//                }
                //还要等的时间小于等于0说明不用等待了
                if (waitTime<=0){
                    break;
                }
                try {
                    /**
                     * 还要考虑虚假唤醒的情况 如在9：00：01秒被虚假唤醒了 此时passTime=1小于timeout2
                     * 所以还会重新等待timeout秒 为了解决 此时应该等待timeout-passTime 算一下还要等待多长时间
                     */
                    this.wait(waitTime);//直接在这里加timeout不行 应为等了这么久以后 退出但又进入了循环
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //循环一轮以后 求得经历时间 wait(2000) 到这了 说明等了2秒 现在是9:00:02秒 passTime就是2秒
                passTime = System.currentTimeMillis() - begin;
            }
            return response;
        }
    }
}
