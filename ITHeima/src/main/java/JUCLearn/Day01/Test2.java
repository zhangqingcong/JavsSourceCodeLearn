package JUCLearn.Day01;

/**
 * 创建线程的第二种方法
 */
public class Test2 {
    public static void main(String[] args) {
        //1、创建任务
       Runnable r = new Runnable(){
           @Override
           public void run() {
               System.out.println("任务1");
           }
       };

        //2、创建线程
        Thread t1 = new Thread(r,"t1");//第一个参数是任务 第二个参数是线程名
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 is running");
            }
        },"t2");

        Thread t3 = new Thread(()->{
            System.out.println("t3线程通过lambda创建");
        },"t3");
        //3、启动线程
        t1.start();
        t2.start();
        t3.start();
        System.out.println("main 线程正在运行 ");
    }


}
