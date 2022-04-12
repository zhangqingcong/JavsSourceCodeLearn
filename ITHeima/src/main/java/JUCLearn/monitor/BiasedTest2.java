package JUCLearn.monitor;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

@Slf4j(topic = "c.BiasedTest2")
public class BiasedTest2 {
    public static void main(String[] args) {
        Cat c = new Cat();
        new Thread(()->{
            //00000101
            log.debug(ClassLayout.parseInstance(c).toPrintable());
            synchronized(c){
                //00000101
                log.debug(ClassLayout.parseInstance(c).toPrintable());
            }
            //00000101
            log.debug(ClassLayout.parseInstance(c).toPrintable());

            synchronized(BiasedTest2.class){
                BiasedTest2.class.notify();
            }
        },"t1").start();

        new Thread(()->{
            synchronized(BiasedTest2.class){
                try {
                    BiasedTest2.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //00000101
            log.debug(ClassLayout.parseInstance(c).toPrintable());
            synchronized(c){
                //00010000
                log.debug(ClassLayout.parseInstance(c).toPrintable());
            }
            //00000001
            log.debug(ClassLayout.parseInstance(c).toPrintable());


        },"t2").start();
    }
}
class Cat{

}
