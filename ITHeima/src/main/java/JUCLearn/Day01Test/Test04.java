package JUCLearn.Day01Test;

import JUCLearn.Constants;
import JUCLearn.n2.util.FileReader;
import lombok.extern.slf4j.Slf4j;

/**
 * run()方法没有启动新线程 继续在main线程里面继续运行
 * start()启动新线程
 */
@Slf4j(topic = "c.Test04")
public class Test04 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                log.debug("running ... ");
                FileReader.read(Constants.MP4_FULL_PATH);
            }
        };
//        t1.run();
        t1.start();
        log.debug("do other things ...");
    }
}
