package JUCLearn.monitor;

import lombok.extern.slf4j.Slf4j;

/**
 * 面向对象改进 把需要保护的变量放入一个类
 */
class Room{
    int value = 0;
    public void increment(){
        synchronized(this){
            value ++;
        }
    }

    public void decrement(){
        synchronized (this){
            value -- ;
        }
    }
    public int get(){
        synchronized (this){
            return value;
        }
    }

}
@Slf4j(topic = "c.Test2")
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                room.increment();
            }
        },"t1");

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                room.decrement();
            }
        },"t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("value: {} ", room.get());
//        System.out.println(room.get());
    }
}
