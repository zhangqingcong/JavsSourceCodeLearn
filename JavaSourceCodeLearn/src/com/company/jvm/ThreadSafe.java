package com.company.jvm;

public class ThreadSafe {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append(4);
        sb.append(5);
        sb.append(6);
        System.out.println();
        new Thread(()->{
            try {
                m2(sb);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 没有线程安全的问题 属性是局部变量 是线程私有的
     * 其他线程没有办法同时访问到该变量
     *
     */
    public static void m1(){
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    /**
     * 不是线程安全的 属性不是局部变量
     * 是方法的一个参数 此时可以用StringBuffer
     * 局部变量引用了对象 线程不安全 引用的是八种基本类型 不影响
     * @param sb
     */
    public static void m2(StringBuilder sb) throws InterruptedException {
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    /**
     * 不是线程安全的 return返回造成了变量逃离作用域
     * @return
     */
    public static StringBuilder m3(){
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        return sb;
    }
}
