package com.company.test;

import java.lang.reflect.Field;

public class ClassDemo {
    public static void main(String[] args) {
        /**
         * 获取反射的class对象的三种方法
         */
        try {
            // 1。Class.forName(String className)
            Class<?> dogClass = Class.forName("com.company.test.Dog");
            Field[] fields = dogClass.getFields();
            for (int i = 0; i < fields.length; i++) {
                System.out.println("获取的非私有属性："+fields[i]);
            }
            Field[] declaredFields = dogClass.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                System.out.println("通过declared获取的："+declaredFields[i]);
            }
//            Class<?> dogClass = Class.forName("com.company.test.Dog.java"); 这样的写法是错误的
            System.out.println(dogClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("没有找到小狗类");
        }
        //2。通过类名.class方法获取反射对象
        Class<Dog> dogClass = Dog.class;
        System.out.println("通过 类名.class方法获取反射的class对象"+dogClass);

        //3。通过类对象.getClass()方法获取反射对象
        Dog dog = new Dog();
        Class<? extends Dog> aClass = dog.getClass();
        try {
            Dog dog1 = aClass.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(aClass);



    }
}
