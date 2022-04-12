package JUCLearn.Day02;

import com.itheima.InnerClass.Test;

/**
 * 只要锁住的是同一个对象 那么临界区的代码就能保证原子性
 * synchronized(对象)
 * {
 *     临界区
 * }
 */
public class SynchronizedDemo01 {
    /**
     * synchronized加在成员方法上
     */
    public synchronized void test(){}

    /**
     * 这种写法等价于synchronized加在成员方法上
     * 应为访问成员方法需要实例化类 所以锁住this就是同一个对象了
     */
    public void test1(){
        synchronized (this)
        {
            //临界区
        }
    }

    /**
     * synchronized加在静态方法上
     */
    public synchronized static void testStatic(){}

    /**
     * 等价于synchronized加在静态方法上
     * 静态方法在堆中存储 一个类只有一份
     * 所以要锁住类对象 才能达到锁住同一对象的目的
     */
    public static void testStatic1(){
        synchronized (Test.class)
        {
            //临界区
        }
    }
}
