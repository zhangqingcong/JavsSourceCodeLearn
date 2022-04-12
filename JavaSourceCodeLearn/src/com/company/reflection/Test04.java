package com.company.reflection;

import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

//哪些类型可以有Class对象
public class Test04 {
    public static void main(String[] args){
        //类可以有class对象
        Class<Object> c1 = Object.class;
        //接口可以有classy对象
        Class<List> c2 = List.class;
        Class<Map> c02 = Map.class;
        System.out.println(c02);
        Class<String[]> c3 = String[].class;//一维数组
        Class<Integer[]> aClass = Integer[].class;
        System.out.println(aClass);
        Class<String[][]> c4 = String[][].class;//二维数组
        Class<Short[][]> aClass1 = Short[][].class;
        System.out.println(aClass1);
        Class<Override> c5 = Override.class;//注解
        Class<SuppressWarnings> suppressWarningsClass = SuppressWarnings.class;
        System.out.println("suppressWarningsClass:"+suppressWarningsClass);
        Class<ElementType> c6 = ElementType.class;//枚举

        Class<Integer> c7 = Integer.class;//内置基本数据类型包装类
        Class<Short> shortClass = Short.class;
        System.out.println("shortclass:"+shortClass);
        Class<Void> c8 = void.class;//void
        String name = c8.getName();
        System.out.println("name:"+name);
        Class<Void> voidClass = Void.class;
        System.out.println("voidClass"+voidClass);
        Class<Class> c9 = Class.class;//Class
        Class<Class> classClass = Class.class;
        System.out.println("666"+classClass);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        //只要元素类型与维度一样，就是同一个class
        int[] a = new int[10];
        int[] b = new int[100];//这是一维的
        int[][] c = new int[2][2];//这是二维的 所以c 与a b不一样
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
        System.out.println(c.getClass().hashCode());

        char[] a1 = new char[]{'a','b'};
        char[] b1 = new char[]{'c'};
        System.out.println(a1.getClass().hashCode());
        System.out.println(b1.getClass().hashCode());
        Field[] declaredFields = a1.getClass().getDeclaredFields();
        Field[] declaredFields1 = b1.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        for (Field field : declaredFields1) {
            System.out.println(field);
        }
        System.out.println(a1[1]);
        System.out.println(b1[0]);
    }
}
