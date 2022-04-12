package com.company.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获取类的信息
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> c1 = Class.forName("com.company.reflection.User");

        //获取类的名字
        System.out.println(c1.getName());//获得包名+类名
        System.out.println(c1.getSimpleName());//获得类名

        //获得类的属性
        Field[] fields = c1.getFields();//这个方法只能找到public属性
        for (Field field : fields) {
            System.out.println(field);
        }
        Field[] declaredFields = c1.getDeclaredFields();//这个可以获得包括是private在内的所有属性
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //获得指定属性的值
//        Field name = c1.getField("name");
//        System.out.println(name);

        Field name1 = c1.getDeclaredField("name");
        System.out.println(name1);


        //获得类的方法
        Method[] methods = c1.getMethods();//获得本类及其父类的全部public方法 不能获得private的
        for (Method method : methods) {
            System.out.println("getMethods方法获取的方法："+method);
        }
        Method[] declaredMethods = c1.getDeclaredMethods();//仅仅获得本类的所有方法 包括私有private的
        for (Method declaredMethod : declaredMethods) {
            System.out.println("getDeclaredMethods方法获取的方法"+declaredMethod);
        }

        //获得指定的方法
        //getMethod方法第一个参数是方法名称，第二个参数是方法的参数类型
        //应为Java中有重载，方法名相同，通过参数来区分要获取的是哪个方法
        Method getNameMethod = c1.getMethod("getName", null);
        Method setNameMethod = c1.getMethod("setName", String.class);
        System.out.println(getNameMethod);
        System.out.println(setNameMethod);

        System.out.println("===================");
        Constructor<?>[] constructors = c1.getConstructors();
        Constructor<?>[] declaredConstructors = c1.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        Constructor<?> constructor = c1.getConstructor(int.class, String.class, int.class);
        System.out.println(constructor);
    }
}
