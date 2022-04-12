import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * 10:49:02 [main] c.ExerciseTransfer - 余票：4082
 * 10:49:02 [main] c.ExerciseTransfer - 卖出的票数：5921
 *
 * 10:49:03 [main] c.ExerciseTransfer - 余票：4068
 * 10:49:03 [main] c.ExerciseTransfer - 卖出的票数：5946
 *
 * 只要思想不滑坡 方法总比苦难多 嘿嘿嘿
 */
@Slf4j(topic = "c.ExerciseTransfer")
@RunWith(Parameterized.class)
public class ExerciseSell {
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[10][0]; // repeat count which you want
    }

    @Test
    public void test() throws InterruptedException {
        //模拟多人买票
        TicketWindow window = new TicketWindow(1000);//余票数为1000张
        //模拟2000个人去窗口买票

        //卖出的票数统计 在多线程中统计使用 所以要使用线程安全的集合
        List<Integer> amountList = new Vector<>();

        //所有线程的集合 把创建出来的线程都放到这里面 这个只在main线程里面使用 所以用ArrayList就可以
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Thread t = new Thread(()->{
                //买票 返回值为买了几张票
                int amount=window.sell(randomAmount());//乘客可能买一张或多张票
                try {
                    Thread.sleep(randomAmount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                amountList.add(amount);//window和amount不是同一个共享变量 不存在线程安全问题
            });
            threadList.add(t);
            t.start();
        }

        // 循环等待所有的线程都执行完毕
        for (Thread thread : threadList) {
            thread.join();
        }

        //统计剩余票数
        log.debug("余票：{}",window.getCount());
        //卖出去的票数
        log.debug("卖出的票数：{}",amountList.stream().mapToInt(i->i).sum());

    }
//    Random 为多线程安全的类
    static Random random = new Random();

    //随机数1～5
    public static int randomAmount(){return random.nextInt(5)+1;}


}
class TicketWindow{
    //余票数 count是成员变量 存在线程安全问题
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    //获取余票数量
    public int getCount() {
        return count;
    }

    //售票  这里对线程共享的成员变量count进行了读写操作 存在线程安全问题
    public synchronized int sell(int amount){
        if (this.count >= amount){
            this.count -= amount;
            return amount;
        }else {
            return 0;
        }
    }
}