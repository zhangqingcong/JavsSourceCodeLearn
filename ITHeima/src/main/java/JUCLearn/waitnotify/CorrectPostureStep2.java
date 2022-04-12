package JUCLearn.waitnotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.CorrectPostureStep2")
public class CorrectPostureStep2 {
    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (room){
                log.debug("有无烟？[{}]",hasCigarette);
                if (!hasCigarette){
                    log.debug("没有烟，歇会");
                    try {
//                        TimeUnit.SECONDS.sleep(2);
                        room.wait(2000 );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                log.debug("有无烟？[{}]",hasCigarette);
                if (hasCigarette){
                    log.debug("有烟了，开始干活");
                }

            }
        },"小南").start();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                synchronized (room){
                    log.debug("其他人使用cpu干活");
                }
            },"其他人").start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
            new Thread(()->{
                hasCigarette = true;
                log.debug("烟送到了");//缺点在于必须等待2秒后才醒 且小南线程不释放锁资源 影响其他线程运行
                synchronized (room) {
                  room.notify();//不放在synchronized代码块里会报InterruptedException错
              }
            },"送烟的").start();
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
