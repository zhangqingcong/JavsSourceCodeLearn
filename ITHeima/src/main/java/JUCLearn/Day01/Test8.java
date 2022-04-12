package JUCLearn.Day01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test8")
public class Test8 {
    public static void main(String[] args) throws InterruptedException {
        log.debug("enter");
        //TimeUnit和sleep效果一样 可读性更高
        TimeUnit.SECONDS.sleep(1);
        log.debug("end");
    }
}
