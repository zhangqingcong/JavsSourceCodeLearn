package JUCLearn.waitnotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.CorrectPostureStep4")
public class CorrectPostureStep4 {
    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (room) {
                log.debug("有无烟？[{}]", hasCigarette);
//                if (!hasCigarette) { //使用if会有虚假唤醒的现象
//                    log.debug("没有烟，歇会");
//                    try {
////                        TimeUnit.SECONDS.sleep(2);
//                        room.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

                while (!hasCigarette) { //使用while
                    log.debug("没有烟，歇会");
                    try {
//                        TimeUnit.SECONDS.sleep(2);
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                log.debug("有无烟？[{}]", hasCigarette);
                if (hasCigarette) {
                    log.debug("有烟了，开始干活");
                } else {
                    log.debug("没干成活...");
                }
            }
        }, "小南").start();
        new Thread(() -> {
            synchronized (room) {
                Thread thread = Thread.currentThread();
                log.debug("有无外卖？[{}]", hasTakeout);
                if (!hasTakeout) {
                    log.debug("没有外卖，歇会");
                    try {
//                        TimeUnit.SECONDS.sleep(2);
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                log.debug("有无外卖？[{}]", hasTakeout);
                if (hasTakeout) {
                    log.debug("有外卖了，开始干活");
                } else {
                    log.debug("没干成活...");
                }
            }
        }, "小女").start();

        try {
            TimeUnit.SECONDS.sleep(1);
            new Thread(() -> {
                synchronized (room) {
                    hasTakeout = true;
                    log.debug("外卖到了");//缺点在于必须等待2秒后才醒 且小南线程不释放锁资源 影响其他线程运行
//                    room.notify();//会引起虚假唤醒的问题
                    room.notifyAll();
                }
            }, "送外卖的").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        try {
//            TimeUnit.SECONDS.sleep(1);
//            new Thread(()->{
//                synchronized (room) {
//                    hasCigarette = true;
//                    log.debug("烟送到了");//加锁不行的哈 这样的话 小南线程睡觉的时候没有释放锁 烟就送不到 必须等时间过后 小南线程逻辑并没有执行
//                }
//            },"送烟的").start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
