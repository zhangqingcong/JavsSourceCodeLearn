package JUCLearn.Day01;

import JUCLearn.Constants;
import JUCLearn.n2.util.FileReader;
import lombok.extern.slf4j.Slf4j;

/**
 * run()和start()方法的区别
 * run方法并没有启动新的线程 还是在main线程里面继续执行
 */
@Slf4j(topic = "c.Tess4")
public class Test4 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.debug("running ... ");
                FileReader.read(Constants.MP4_FULL_PATH);
            }
        };
//        t1.run();
        t1.start();//start方法才开启新的线程
        log.debug("do other things...");
    }
}
