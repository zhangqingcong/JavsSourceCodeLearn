package JUCLearn.Day01;

/**
 *
 */
public class ThreadTest02 {
    public static void main(String[] args) {
        /**
         *  这是任务，线程和任务分开了
         *  使用Runnable让任务类脱离了Thread继承体系，更灵活
         */
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("thread is running");
            }
        };
        //1、创建线程
        Thread t = new Thread(r,"threadName");
        //2、启动线程
        t.start();
        System.out.println("main is running");
    }
}
