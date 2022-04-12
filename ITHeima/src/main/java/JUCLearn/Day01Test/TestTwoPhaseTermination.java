package JUCLearn.Day01Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 两阶段终止模式
 * Two Phase Termination
 * 如何在一个线程t1中如何优雅的终止线程T2 这里的优雅指的是给T2一个料理厚实的机会
 *错误方法
 * stop()会真的杀死线程 若此时线程锁住了共享资源 那么当他被杀死后就没有机会释放锁 其他线程就永远没有机会获取锁
 *
 * System.exit(int)停止线程 这种做法会停止所有的程序
 */
@Slf4j(topic = "c.TestTwoPhaseTermination")
public class TestTwoPhaseTermination {
    public static void main(String[] args) throws InterruptedException {
    TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
    twoPhaseTermination.start();

    Thread.sleep(3500);
    twoPhaseTermination.stop();
    }
}
@Slf4j(topic = "c.TwoPhaseTermination")
class TwoPhaseTermination{
    private Thread monitor;

    //启动监控线程
    public void start(){
        monitor =new Thread(()->{
            while (true){
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()){
                    log.debug("料事后事，释放资源");
                    break;
                }
                try {
                    Thread.sleep(1000);//情况1
                    log.debug("执行监控记录");//情况2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //重新设置打断标记
                    currentThread.interrupt();
                }
            }
        });

        monitor.start();
    }
    //停止监控线程
    public void stop(){
        monitor.interrupt();
    }
}
