package com.itheima.threadlocal;

/**
 * | 方法声明                  | 描述                       |
 * | ------------------------- | -------------------------- |
 * | ThreadLocal()             | 创建ThreadLocal对象        |
 * | public void set( T value) | 设置当前线程绑定的局部变量 |
 * | public T get()            | 获取当前线程绑定的局部变量 |
 * | public void remove()      | 移除当前线程绑定的局部变量 |
 */
public class Demo01 {
    ThreadLocal<String> tl = new ThreadLocal<>();
    private String content;
    private String getContent(){
        String s = tl.get();
        return s;
    }

    public void setContent(String content) {
        tl.set(content);
    }

    public static void main(String[] args) {
        Demo01 d = new Demo01();
        for (int i = 0; i < 5; i++) {
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            });
            Thread t = new Thread(()->{
                d.setContent(Thread.currentThread().getName()+"的数据");
                System.out.println("-------------------");
                System.out.println(Thread.currentThread().getName()+"------>"+d.getContent());
            });
            t.setName("线程"+i);
            t.start();
        }

    }
}
