package JUCLearn.Day02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test8Locks")
public class Test8Locks {
    /**
     * 10:15:29 [b] c.Test8Locks - begin
     * 10:15:29 [b] c.Number - 2
     * 10:15:29 [a] c.Test8Locks - begin
     * 10:15:29 [a] c.Number - 1
     * 这种情况 1 2 和2 1都有可能出现 但是先启动的上面的线程 所以大概率出现1 2 测试时也出现了2 1
     * @param args
     */
    public static void main(String[] args) {
        Number n = new Number();
         new Thread(()->{
            log.debug("begin");
             try {
                 n.a();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         },"a").start();

         new Thread(()->{
             log.debug("begin");
             n.b();
         },"b").start();

        new Thread(()->{
            log.debug("begin");
            n.c();
        },"c").start();
    }
}
@Slf4j(topic = "c.Number")
class Number{
    public synchronized void a() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);//这里Sleep一秒 可能 2 1秒后1 也可能是1秒后 1 2
        log.debug("1");
    }

    public synchronized void b(){
        log.debug("2");
    }
    public  void c(){
        log.debug("3");//c方法不加锁 则可能先启动 2 3 线程 然后1秒后打印1 也可能是3 2 然后1秒后打印1 也能先启动1线程 1秒后打印23 32
    }
}
