package com.company.test;

import java.util.*;

public class DemoHashmap {
    public static void main(String[] args) {
        //集合中无法存储基本数据类型的变量 可以存对应的包装类
//        Map<int> map = new HashMap();
        Map<String,Integer> map = new HashMap<>();
        map.put("姓名",101);
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("j");
        //只有单列集合才有迭代器
//        map.iterator();
        //返回的迭代器指向集合对象的0号索引位置
//        Iterator iterator = list.iterator();
//        //不知道循环多少次的时候 使用while循环
//        //判断还有没有下一个元素
//        while (iterator.hasNext()){
//            //这个next方法可以这么理解，从这个元素的左边越到这个元素的右边 然后返回这个元素
//            String s = (String) iterator.next();
//            System.out.println(s+" ");
//            //赋值操作不生效 内容中相当于有个第三方容器放从集合中迭代遍历出来的内容，修改这个值并不会影响原集合的内容
//            s = "false";
//            System.out.println("赋值以后的S："+s);
//            System.out.println(list.toString());
//        }
        System.out.println("---------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
            list.remove(i);
            i--;//如果没有脚标减1 会删除错误
        }
        System.out.println("普通for循环删除以后的list集合"+list.toString());
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("b");
        list1.add("c");
        //普通for循环删除ArrayList集合的时候剩下的元素会往前挤，但是角标i已经+1了，所有还要注意角标i--才能避免出错 一般不用这种删除方法
        for (int i = 0; i < list1.size(); i++) {
            if ("b"==list1.get(i)){
                list1.remove(i);
                i--;
            }
            System.out.println(list1);
        }
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        list2.add("e");
        list2.add("f");
        list2.add("j");
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()){
            iterator.next();//没有这句代码不行 不往前移动
            iterator.remove();//删除也要在next()方法调用之后
        }
        System.out.println(list2.toString());


    }



}
