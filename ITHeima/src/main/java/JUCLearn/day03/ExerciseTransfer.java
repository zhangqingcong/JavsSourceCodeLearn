package JUCLearn.day03;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j(topic = "c.ExerciseTransfer")
public class ExerciseTransfer {
    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1000);
        Account b = new Account(1000);
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                a.transfer(b,randomAmount());
            }
        },"t1");
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                b.transfer(a,randomAmount());
            }
        },"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //查看转账2000次后的总金额
        log.debug("total:{}",(a.getMoney()+b.getMoney()));

    }

    //random是线程安全的
    static Random r = new Random();

    //返回一个1～100的随机数
    public static int randomAmount(){
        return r.nextInt(100)+1;
    }
}

class Account {
    private int money;

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //要给两个变量加锁了 此时synchronized加在成员方法上 保护的是this.money  target.money变量还没有保护
    //所以要加在synchronized(Account.class){
    // }
    /**
     * 相当于synchronize(this){
     *
     * }
     * @param target
     * @param amount
     */
    public  void transfer(Account target, int amount) {
        synchronized (Account.class){
        if (this.money > amount) {
            this.setMoney(this.getMoney() - amount);
            target.setMoney(target.getMoney() + amount);
        }
        }
    }
}