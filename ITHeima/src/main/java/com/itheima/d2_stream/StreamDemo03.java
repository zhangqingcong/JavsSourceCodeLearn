package com.itheima.d2_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        //Stream<T> filter(Predicate<? super T> predicate)
        //T代表的是Stream流里面的元素类型
//        Stream<String> stringStream = list.stream().filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.startsWith("张");
//            }
//        });

        list.stream().filter(s -> s.startsWith("张")).forEach(s-> System.out.println(s));
        long count = list.stream().filter(s -> s.length() == 3).count();
        System.out.println(count);
        System.out.println("------------------");
//        list.stream().filter(s->s.startsWith("张")).limit(2).forEach(s -> System.out.println(s));
        //方法引用 注意 这里的limit是限制显示几个元素 不是限制元素内容长度为多少的
        list.stream().filter(s -> s.startsWith("张")).limit(2).forEach(System.out::println);
        list.stream().filter(s->s.startsWith("张")).skip(2).forEach(System.out::println );

        //Map加工方法 第一个参数是原材料 第二个参数是加工后的结果
        list.stream().map(new Function<String, String>() {

            @Override
            public String apply(String s) {
                return "黑马的"+s;
            }
        }).forEach( System.out::println);
        list.stream().map(s-> "简化的："+s).forEach(System.out::println);

        list.stream().map(s -> new Student(s)).forEach(System.out::println);
        list.stream().map(Student::new).forEach(System.out::println);//构造器引用 方法引用

        //合并流
        Stream<String> stringStream = list.stream().filter(s -> s.startsWith("张"));
        stringStream.distinct().forEach(System.out::println);
//        Stream<Integer> stream = Stream.of(1, 2);
        //    static <T> Stream<T> concat(Stream<? extends T> var0, Stream<? extends T> var1) {
//        Stream<String> concatStream = Stream.concat(stringStream, stream);
//        concatStream.forEach(System.out::println);
//        Stream<Object> concatStream1 = Stream.concat(stream, stringStream);
//        concatStream1.distinct();
//        concatStream1.forEach(System.out::print);


    }

}
