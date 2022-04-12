package JUCLearn.Day01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程的第三种方式
 * 此种创建线程的方式会有返回结果
 */
public class Test3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task1 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("thread is running ...");
                TimeUnit.SECONDS.sleep(1);
                return 100;
            }
        });

        FutureTask<String> task2 = new FutureTask<>(() -> {
            System.out.println("返回结果的线程");
            return "hello word";
        });

        Thread t1 = new Thread(task1,"t1");
        Thread t2 = new Thread(task2,"t2");
        Thread t3 = new Thread(new FutureTask<String>(()->{return "t3";}),"t3");

        t1.start();
        t2.start();
        t3.start();
        Integer integer = task1.get();
        String s = task2.get();

        System.out.println(integer);
        System.out.println(s);
    }
}
