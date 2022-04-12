package JUCLearn.Day01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.test13")
public class Test13 {
    public static void main(String[] args) throws InterruptedException {
    TwoPhaseTermination tpt = new TwoPhaseTermination();
    tpt.start();

    TimeUnit.SECONDS.sleep(3);
    tpt.stop();
    }

}
@Slf4j(topic = "c.TwoPhaseTermination")
class TwoPhaseTermination{
    private Thread monitorThread;

    public void start(){
        monitorThread = new Thread(()->{
            while (true){
                Thread thread = Thread.currentThread();
                if (thread.isInterrupted()){
                    log.debug("料理后事");
                    break;
                }
                try{
                    Thread.sleep(1000);// 情况1 休眠期间被打断 进catch块 此时的打断标记为false
                    log.debug("执行监控记录"); //情况2 正常执行期间被打断 打断标记设置为true
                }catch (InterruptedException e){
                    e.printStackTrace();
//                    thread.interrupt();//情况一 设置打断标记为true
                }
            }
        });
        monitorThread.start();
    }

    //停止监控线程
    public void stop(){
        monitorThread.interrupt();
    }
}
