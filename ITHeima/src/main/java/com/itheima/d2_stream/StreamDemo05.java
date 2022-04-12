package com.itheima.d2_stream;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 收集stream流的数据到 集合或者数组
 */
public class StreamDemo05 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        Stream<String> stringStream = list.stream().filter(s -> s.startsWith("张"));
        List<String> stringList = stringStream.collect(Collectors.toList());
        boolean b = stringList.add("扫地僧");
        System.out.println(stringList);
        //Exception in thread "main" java.lang.UnsupportedOperationException
////        List<String> list1 = stringStream.toList();//java 16支持的特性 返回的集合不允许修改
//        list1.add("test");
//        System.out.println(list1);

        //stream has already been operated upon or closed 流只能使用一次
        Stream<String> s2 = list.stream().filter(s -> s.startsWith("张"));

        Set<String> stringSet = s2.collect(Collectors.toSet());
        System.out.println(stringSet);

        Stream<String> s3 = list.stream().filter(s -> s.startsWith("张"));
//        Object[] objects = s3.toArray();
//        String[] strings = s3.toArray(new IntFunction<String[]>() {
//            @Override
//            public String[] apply(int i) {
//                return new String[i];
//            }
//        });
//        String[] ss = s3.toArray(i -> new String[i]);
        String[] ss = s3.toArray(String[]::new);
        System.out.println("Arrays数组内容："+ Arrays.toString(ss));
    }
}
