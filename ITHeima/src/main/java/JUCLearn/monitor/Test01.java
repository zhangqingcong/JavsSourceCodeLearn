package JUCLearn.monitor;

public class Test01 {
    static final Object lock = new Object();
    static int counter = 0;
    public static void main(String[] args) {
        synchronized(lock){
            counter++;
        }
    }
}
