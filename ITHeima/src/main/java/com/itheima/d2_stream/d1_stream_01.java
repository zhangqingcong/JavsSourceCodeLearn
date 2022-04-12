package com.itheima.d2_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d1_stream_01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        List<String> zhangList = new ArrayList<>();
        for (String s : list) {
           if (s.startsWith("张")){
               zhangList.add(s);
           }
        }

        System.out.println(zhangList);
        List<String> threeList = new ArrayList<>();
        for (String s : zhangList) {
            if (s.length()==3){
                threeList.add(s);
            }
        }
        System.out.println(threeList);

    }
}