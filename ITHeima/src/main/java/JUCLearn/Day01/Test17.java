package JUCLearn.Day01;

import lombok.extern.slf4j.Slf4j;

/**
 * synchronized(对象){//理论上这个对象可以是任何对象 只要锁住的是同一个对象即可
 *
 * }
 */
@Slf4j(topic = "c.Test17")
public class Test17 {
    public static void main(String[] args) {
        Room r = new Room();
        Thread t1 = new Thread(()->{

            for (int i = 0; i < 5000; i++) {
//                synchronized(Lock) {
//                    counter++;
//                }
                r.increment();

            }

        },"t1");

        Thread t2 = new Thread(()->{

                for (int i = 0; i < 5000; i++) {
//                    synchronized (Lock){
//                    counter--;
//                    }
                    r.decrement();
                }

        },"t2");

        t1.start();
        t2.start();//启动两个线程
        try {
            t1.join();
            t2.join();//主线程中等待t1 t2线程运行结束
            log.debug("{}",r.getCounter() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Room{
    private int counter = 0;
    public void increment(){
    synchronized (this){
        counter++;
    }
    }
    public void decrement(){
        synchronized (this){
            counter--;
        }
    }

    /**
     * 获取也需要加锁 上面的修改进行了加锁 那么获得也必须加锁 防止获得他们的中间变量
     * @return
     */
    public int getCounter(){
        synchronized (this){
            return counter;
        }
    }
}
