package JUCLearn.monitor;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.Vector;
import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.BatchCancelBiased")
public class BatchCancelBiased {
    static Thread t1, t2, t3;

    public static void main(String[] args) throws InterruptedException {
//        int loopNumber = 39; 达到40次的上限 撤销锁偏向 新创建的对象为001 normal无锁
        //没有达到上限 没有撤销锁偏向 新创建的对象为101 biased 偏向锁 偏向线程t3 此时mark word里面存储的是t3的线程id
        int loopNumber = 38;
        Vector<Boy> list = new Vector<>();
        t1 = new Thread(() -> {
            for (int i = 0; i < loopNumber; i++) {
                Boy b = new Boy();
                list.add(b);
                synchronized (b) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(b).toPrintable());
                }
            }
            LockSupport.unpark(t2);
        }, "t1");
        t1.start();

        t2 = new Thread(() -> {
            LockSupport.park();
            log.debug("===============>>>>>");
            for (int i = 0; i < loopNumber; i++) {
                Boy b = list.get(i);
                log.debug(i + "\t" + ClassLayout.parseInstance(b).toPrintable());
                synchronized (b) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(b).toPrintable());
                }
                log.debug(i + "\t" + ClassLayout.parseInstance(b).toPrintable());
            }
            //唤醒t3
            LockSupport.unpark(t3);
        }, "t2");
        t2.start();
        t3 = new Thread(() -> {
            //等待t2唤醒
            LockSupport.park(t2);
            log.debug("=======================>");
            for (int i = 0; i < loopNumber; i++) {
                Boy b = list.get(i);
                log.debug(i + "\t" + ClassLayout.parseInstance(b).toPrintable());
                synchronized (b) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(b).toPrintable());
                }
                log.debug(i + "\t" + ClassLayout.parseInstance(b).toPrintable());
            }

        }, "t3");
        t3.start();

        t3.join();
        log.debug("\t" + ClassLayout.parseInstance(new Boy()).toPrintable());
    }
}

class Boy {
}