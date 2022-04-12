package com.itheima.d2_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1、stream简化了集合、数组操作的API。结合Lambda表达式
 * 2、使用步骤
 *  2、1 先得到集合或者数组的Stream流（就是一根传送带）
 *  2、2 把元素放上去
 *  2、3 然后就用这个Stream流简化的API来方便的操作元素
 *
 * 3、Stream流的三类方法
 *  获取Stream流
 *  中间方法
 *  终结方法
 */
public class d1_stream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"张三丰","张无忌","周芷若","赵敏","张某");
        System.out.println(names);

        //1、找出姓张的集合
        List<String> zhangList = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("张")){
                zhangList.add(name);
            }
        }
        System.out.println(zhangList);

        //2、按名称长度是3的姓名
        List<String> zhangThreeList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length()==3){
                zhangThreeList.add(name);
            }
        }
        System.out.println(zhangThreeList);

        //3、使用Stream实现
        names.stream().filter(s -> s.startsWith("张")).filter(s->s.length()==3).forEach(s-> System.out.println(s));
    }
}
