package com.company.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

public class CollectionDemo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        Iterator<String> iterator = list.iterator();//调用迭代器对象，返回一个指向这个集合第一个元素的迭代器对象
        while (iterator.hasNext()){
            String s = iterator.next();//注意 这里的s是一个暂存用来放置list集合中变量的，修改这个值并不会修改原list集合中的值
            if ("A"==s){
                s="a";
            }else if ("B"==s){
                s="b";
            }else if ("C"==s){
                s="c";
            }else if ("D"==s){
                s="d";
            }else if ("E"==s){
                s="e";
            }else if ("F"==s){
                s="f";
            }
            System.out.println(s);
        }
        System.out.println(list.toString());



        List<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("B");
        list2.add("B");
        list2.add("D");
        list2.add("E");
        list2.add("F");
        for (int i = 0; i < list2.size(); i++) {
            list2.remove(i);
            i--;
        }
        System.out.println(list2.toString());
        System.out.println("--------");
        List<String> list3 = new ArrayList<>();
        list3.add("A3");
        list3.add("B3");
        list3.add("B3");
        list3.add("D3");
        list3.add("E3");
        list3.add("F3");
        //增强for循环的作用： 简化迭代器的书写格式。(注意：增强for循环的底层还是使用了迭代器遍历。)
        //增强for循环的适用范围： 如果是实现了Iterable接口的对象或者是数组对象都可以使用增强for循环。
        //增强for循环的缺点：增强for循环和iterator遍历的效果是一样的，也就说增强for循环的内部也就是调用iteratoer实现的，但是增强for循环有些缺点，例如不能在增强循环里动态的删除集合内容、不能获取下标等。
        //
        //
        //————————————————
        for(String s : list3){
            System.out.print(s+" ");
            list3.clear();
        }
        System.out.println();

        System.out.println(list3.toString());
    }
}
