package JUCLearn.waitnotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestGuardedObject01")
public class TestGuardedObject01 {
    public static void main(String[] args) {
        GuardedObject01 guardedObject01 = new GuardedObject01();
        new Thread(()->{
            log.debug("Start ...");
            Object response = guardedObject01.get(2000);
            log.debug("结果是：{}",response);
        },"t1").start();

        new Thread(()->{
            log.debug("begin ... ");
            try {
                TimeUnit.SECONDS.sleep(1);
//                guardedObject01.complete(new Object());
                guardedObject01.complete(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}

class GuardedObject01{
    //两个线程之间传递的结果
    private Object response;

    //产生结果的方法
    public void complete(Object response){
        synchronized (this){
            //生产结果的线程调用这个方法 把生产的结果赋值给中间变量
            this.response = response;
            //得到结果以后 唤醒wait中的线程
            this.notifyAll();
        }
    }

    //获得结果的方法 需要获取另外一个线程产生结果的线程调用这个方法
    public Object get(){
        synchronized (this){
            //如果结果为null说明还没有获得结果
            while (response == null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    public Object get(long timeout){
        synchronized (this){
            long begin = System.currentTimeMillis();
            long passTime = 0;
            while (response ==null){
                long waitTime = timeout - passTime;
                if (waitTime<=0){
                    break;
                }
                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               passTime = System.currentTimeMillis()-begin;
            }
        }
        return response;
    }
}
