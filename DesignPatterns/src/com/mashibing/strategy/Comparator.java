package com.mashibing.strategy;

public interface Comparator<T> {
    int compare(T o1, T o2);
    //1.8以后接口一面可以有默认的方法
    default void m(){
        System.out.println("m");
    }
}
