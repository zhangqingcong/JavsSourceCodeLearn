package JUCLearn.monitor;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

@Slf4j(topic = "c.BiasedTest")
public class BiasedTest {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.hashCode();//调用对象的hashCode会禁用掉偏向锁
        log.debug(ClassLayout.parseInstance(d).toPrintable());
        synchronized (d){
        log.debug(ClassLayout.parseInstance(d).toPrintable());
        }
        log.debug(ClassLayout.parseInstance(d).toPrintable());
    }
}
class Dog{

}
