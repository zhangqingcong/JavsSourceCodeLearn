package JUCLearn.Day02;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestBiased")
public class TestBiased {

    public static void main(String[] args) throws InterruptedException {
        Dog dog = new Dog();
        log.debug(ClassLayout.parseInstance(dog).toPrintable());
        TimeUnit.SECONDS.sleep(4);
        log.debug(ClassLayout.parseInstance(new Dog()).toPrintable());

    }

}

class Dog {

}
