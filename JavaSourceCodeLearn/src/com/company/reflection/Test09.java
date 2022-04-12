package com.company.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象，通过反射
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //先获得Class对象
        Class<?> c1 = Class.forName("com.company.reflection.User");

        //构造一个对象
//        User user = (User) c1.newInstance();//本质是调用了类的无参构造器
//        System.out.println(user);

        //通过构造器创建对象
//        Constructorstructor<Constructor?> companynstructor = c1.getDeclaredConstructor(int.class, String.class, int.class);
//        User user1 = (User) constructor.newInstance(18, "tom", 180);
//        System.out.println(user1);

        //通过反射调用普通方法

        User user3 = (User) c1.newInstance();//获取对象
        Method setName = c1.getDeclaredMethod("setName", String.class);//获取方法
        //第一个参数 往哪个对象的该方法，传入该方法的参数
        setName.invoke(user3, "jerry");

        System.out.println(user3.getName());

        //通过反射操作属性
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，需要使用setAccessible()方法
        name.setAccessible(true);
        name.set(user4,"jerry02");
        System.out.println(user4.getName());




    }
}
