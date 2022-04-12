package JUCLearn.Day01;

/**
 * 创建线程的一种方式
 * 线程和任务合并在一起了
 */
public class Test1 {
    public static void main(String[] args) {

        //1、先创建一个线程对象
//        Thread t = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("thread is running");
//            }
//        };
//        Thread t1 = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("t1线程启动了");
//            }
//        };
//        t1.setName("t1");
//        t.setName("线程名");//给线程起名
        //2、启动线程
//        t.start();
//        t1.start();


//        System.out.println("main is running");

        //1、创建一个线程
       Thread thread = new Thread(){
           @Override
           public void run() {
               System.out.println("线程正在运行");
           }
       };
       //用lambada创建线程
        Thread t2 = new Thread(()->{
            System.out.println("t2线程通过lambda创建了出来");
        },"t2");
        //1.1给线程起名
        thread.setName("t1");

        new Thread(()-> System.out.println("t3线程"),"t3");
        //2、启动线程
        thread.start();
        t2.start();
        System.out.println("main thread is running");
    }
}
