package JUCLearn.monitor;

public class WaitAndNotify {
    static final Object lock = new Object();
    public static void main(String[] args) {
        //没有获取锁是不能调用wait()和notify()方法的
//            lock.wait();//java.lang.IllegalMonitorStateException
        lock.notify();

        //获得对象锁以后才可以使用wait()和notify()方法
//        synchronized(lock){
//            try {
//                lock.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
