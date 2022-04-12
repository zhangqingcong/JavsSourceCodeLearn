package JUCLearn.day03;

import java.util.ArrayList;
import java.util.Hashtable;

public class TestThreadSafe {
    static final int THREAD_NUMBER =2;
    static final int LOOP_NUMBER =200;
    private static final Object lock = new Object();
    public static void main(String[] args) {

//        ThreadUnsafe t = new ThreadUnsafe();
//        ThreadSafe t = new ThreadSafe();
        ThreadSafeSubClass t = new ThreadSafeSubClass();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(()->{
                   t.method1(LOOP_NUMBER);
                         }
            ,"Thread"+(i+1)).start();
        }
    }
}

class ThreadUnsafe{
    //成员变量 存在线程安全问题
    ArrayList<String> list = new ArrayList<>();
    public void method1(int loopNumber){
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                method2();//这两行代码是临界区 加锁可保证线程安全
                method3();
            }
        }
    }

    private void method2() {
        list.add("1");
    }

    private void method3() {
        list.remove(0);
    }
}

class ThreadSafe{
    //公共方法加final 防止子类重写该方法 从而导致不可知的问题
    public final void method1(int loopNumber){
        //把成员变量变成局部变量 并且局部变量的引用没有暴漏给外部 在堆中每个线程都有各自对的list对象
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < loopNumber; i++) {
            method2(list);
            method3(list);
        }
    }

    //private作为方法修饰符能够起到保护线程安全的作用 可以不让子类重写
    private void method2(ArrayList<String> list) {
        list.add("1");
    }

    private void method3(ArrayList<String> list) {
        list.remove(0);
    }
}
class ThreadSafePublic{
    public final void method1(int loopNumber){
        //把成员变量变成局部变量 并且局部变量的引用没有暴漏给外部 在堆中每个线程都有各自对的list对象
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < loopNumber; i++) {
            method2(list);
            method3(list);
        }
    }

    //和上面的方法不同之处在于这里的方法是public不是private 但同样是线程安全的 应为线程2传过来的list是新创建的
    //不是线程1传递过来的
    public void method2(ArrayList<String> list) {
        list.add("1");
    }

    public void method3(ArrayList<String> list) {
        list.remove(0);
    }
}
class ThreadSafeSubClass extends ThreadSafePublic{
    @Override
    public void method3(ArrayList<String> list) {
        new Thread(()->{
            list.remove(0);
        }).start();
    }
}
