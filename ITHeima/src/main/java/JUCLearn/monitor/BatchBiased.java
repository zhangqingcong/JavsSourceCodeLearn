package JUCLearn.monitor;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.Vector;

@Slf4j(topic = "c.BatchBiased")
public class BatchBiased {
    public static void main(String[] args) {
        Vector<Dragon> list = new Vector<>();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                Dragon d = new Dragon();
                list.add(d);
                synchronized (d){
                    log.debug(i+"\t"+ ClassLayout.parseInstance(d).toPrintable());
                }
            }
            synchronized (list){
                list.notify();
            }
        },"t1").start();

        new Thread(()->{
            synchronized (list){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("====================>>>");
            for (int i = 0; i < 30; i++) {
                Dragon d = list.get(i);
                log.debug(i+"\t"+ ClassLayout.parseInstance(d).toPrintable());
                synchronized (d){
                    log.debug(i+"\t"+ ClassLayout.parseInstance(d).toPrintable());
                }
                log.debug(i+"\t"+ ClassLayout.parseInstance(d).toPrintable());
            }

        },"t2").start();
    }

 }

class Dragon {}
