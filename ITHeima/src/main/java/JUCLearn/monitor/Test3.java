package JUCLearn.monitor;

public class Test3 {
    public synchronized void test1(){

    }
    public void test2(){
        synchronized(this){

        }
    }

    public synchronized static void test3(){

    }
    public static void test4(){
        synchronized(Test.class){

        }
    }
}
