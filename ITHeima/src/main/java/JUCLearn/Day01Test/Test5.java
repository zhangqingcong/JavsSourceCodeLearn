package JUCLearn.Day01Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test5")
public class Test5 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.debug("t1 thread is running");
            }
        };
        //线程状态
        Thread.State threadState = t1.getState();
        log.debug("线程当前的状态：{}",threadState);
        t1.start();
//        t1.start();//java.lang.IllegalThreadStateException
        log.debug("启动以后线程的状态：{}",t1.getState());
        //线程的类加载器
        ClassLoader contextClassLoader = t1.getContextClassLoader();
        long id = t1.getId();
        int priority = t1.getPriority();
        String name = t1.getName();
        StackTraceElement[] stackTrace = t1.getStackTrace();
        ThreadGroup threadGroup = t1.getThreadGroup();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = t1.getUncaughtExceptionHandler();
        log.debug("线程当前的类加载器：{}",contextClassLoader);
        log.debug("线程当前的id：{}",id);
        log.debug("线程当前的优先级：{}",priority);
        log.debug("线程当前的名称：{}",name);
        log.debug("线程当前的stackTrace：{}",stackTrace);
        log.debug("线程当前的threadGroup：{}",threadGroup);
        log.debug("线程当前的uncaughtExceptionHandler：{}",uncaughtExceptionHandler);

    }
}
