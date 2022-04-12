package JUCLearn.waitnotify;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestGuardedObject2")
public class TestGuardedObject2 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new People().start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
            for (Integer id : Mailboxes.getIds()) {
                new Postman(id,"内容"+id).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

@Slf4j(topic = "c.People")
class People extends Thread{
    @Override
    public void run() {
        //收信
        GuardedObject2 guardedObject = Mailboxes.createGuardedObject();
        log.debug("开始 收信 id:{}",guardedObject.getId());
        Object mail = guardedObject.get(5000);
        log.debug("收信完成 id:{},内容：{}",guardedObject.getId(),mail);

    }
}

@Slf4j(topic = "c.Postman")
class Postman extends Thread{
    private int id;
    private String mail;
    public Postman(int id,String mail){
        this.id=id;
        this.mail=mail;
    }

    @Override
    public void run() {
        GuardedObject2 guardObject = Mailboxes.getGuardObject(id);
        log.debug("邮递员开始 送信信 id:{},内容：{}",id,mail);
        guardObject.complete(mail);
    }
}

class Mailboxes{
    //应为要多个线程共享使用这个变量
    private static Map<Integer,GuardedObject2> boxes = new ConcurrentHashMap<>();

    private static int id =1;
    //产生唯一id 放在Mailboxes内部来维护 如果外部来维护比如让邮递员类或者住户类来维护可能产生Mailboxes编号冲突

    /**
     * 这个方法会被多个线程同时访问 所有使用synchronized关键字修饰方法
     * 加static相当于锁住的是Mailboxes类
     * @return
     */
    private static synchronized int generateId(){
        return id++;
    }

    /**
     * 产生对象
     * @return
     */
    public static GuardedObject2 createGuardedObject(){
        GuardedObject2 go = new GuardedObject2(generateId());
        boxes.put(go.getId(),go);
        return go;
    }

    public static Set<Integer> getIds(){
        return boxes.keySet();
    }

    public static GuardedObject2 getGuardObject(int id){
//        return boxes.get(id);//这里不把map中的给移除 boxes是静态的 一直获取会造成内存泄漏
        return boxes.remove(id);
    }

}

class GuardedObject2 {
    public GuardedObject2(int id) {
        this.id = id;
    }

    //标识 Guarded Object
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //结果
    private Object response;

    //产生结果
    public void complete(Object response) {
        synchronized (this) {
            // 产生结果的线程调用这个方法 把返回的结果生产出来
            this.response = response;
            // 结果生产出来了 就可以唤醒wait的线程
            this.notifyAll();
        }
    }

    //获得结果
    public Object get() {
        synchronized (this) {
            //while循环 防止虚假唤醒
            while (response == null) {
                try {
                    //获得结果的线程调用get()方法 没有结果返回 就wait()
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    //获得结果 等待一定超时时间 到达超时时间还没有获得就不再等待
    public Object get(long timeout){

        synchronized (this){
            long begin = System.currentTimeMillis();
            //还没开始循环 循环经过的时间是0
            long passTime = 0 ;
            while (response ==null){
                //每轮循环应该等待的时间
                long waitTime = timeout - passTime;
                //如果本轮循环应该等待的时间已经小于等于0了 就跳出循环 不在等待 说明已经获得结果的线程已经等待了设置的超时时间也没得到结果
                if (waitTime<=0){
                    break;
                }
                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //每次循环完毕经历了多长时间
               passTime = System.currentTimeMillis()-begin;
            }
            return response;
        }
    }
}
