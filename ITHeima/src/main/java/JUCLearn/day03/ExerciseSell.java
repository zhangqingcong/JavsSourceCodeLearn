package JUCLearn.day03;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

@Slf4j(topic = "c.ExerciseSell")
public class ExerciseSell {
    public static void main(String[] args) throws InterruptedException {
        //模拟多人买票
        TicketWindow window = new TicketWindow(10000);//余票数为1000张
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
    //Random 为多线程安全的类
    static Random random = new Random();

    //随机数1～5
   public static int randomAmount(){return random.nextInt(5)+1;}
}
class TicketWindow{
    //余票数
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    //获取余票数量
    public int getCount() {
        return count;
    }

    //售票
    public int sell(int amount){
        if (this.count >= amount){
            this.count -= amount;
            return amount;
        }else {
            return 0;
        }
    }
}
