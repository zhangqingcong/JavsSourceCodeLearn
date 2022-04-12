package com.company.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //通过反射获取类的class对象
        Class c1 = Class.forName("com.company.reflection.User");
//        System.out.println(c1);

        Class c01 = Class.forName("com.company.reflection.User");
        //一个类在内存中有且只有一个class对象 hashCode都一样
//        System.out.println(c1.hashCode());
//        System.out.println(c01.hashCode());
        //一个类被加载后，类的整个结构都会被封装在class对象中
        Class<?> c2 = Class.forName("com.company.reflection.User");
        Class<?> c3 = Class.forName("com.company.reflection.User");
        Class<?> c4 = Class.forName("com.company.reflection.User");
//        System.out.println(c2.hashCode());
//        System.out.println(c3.hashCode());
//        System.out.println(c4.hashCode());

        //getName()返回此class对象所表示的实体（类，接口，数组类或void）的名称
        String className = c2.getName();
        //com.company.reflection.User
//        System.out.println(className);
        Class c03 = Class.forName("java.lang.Runnable");//接口
//        System.out.println(c03);
//        Class c04 = Class.forName("java.lang.Void");//void
        Class<?> c04 = Class.forName("java.lang.Void");
//        System.out.println(c04);


        //newInstance()调用无参构造返回一个Class对象的一个实例
        User user = (User) c1.newInstance();
//        System.out.println(user);
        //返回当前Class对象的父类的Class对象
        Class superclass = c1.getSuperclass();
//        System.out.println(superclass);
        //返回当前class对象的实现的接口
//        List list = new ArrayList();
        Map<String, String> hashMap = new HashMap<>();
        Class<? extends Map> h = hashMap.getClass();
        Class<?>[] interfaces = h.getInterfaces();
        for (Class<?> in : interfaces) {
//            System.out.println(in);
        }

        //返回该类的类加载器
        ClassLoader classLoader = c1.getClassLoader();
//        System.out.println(classLoader);
        ClassLoader hc = h.getClassLoader();
        //BootClassLoader 类加载器加载 C/C++语言编写 Java语言获取不到
//        System.out.println(hc);

        //返回构造器对象数组
        Constructor<?>[] constructors = c1.getConstructors();
        Constructor<?>[] constructors1 = h.getConstructors();
        for (Constructor<?> constructor : constructors) {
//            System.out.println(constructor);
        }
        for (Constructor<?> constructor : constructors1) {
//            System.out.println(constructors1);
        }

        //getMethod两个参数，第一个参数是方法名，第二个参数是方法的参数类型
//        Method getName = c1.getMethod("getName");
        //返回值是Method对象
        /**
         * 反射获得的Method对象封装了方法的所有信息
         *
         */
        Method getName = c1.getMethod("getName");
        Method setAge = c1.getMethod("setAge", int.class);
        //返回值
//        System.out.println(getName);
        //方法的名称
        String methodName = getName.getName();
//        System.out.println(methodName);

        //方法的返回值类型
        Class<?> returnType = getName.getReturnType();
//        System.out.println(returnType);
        Class<?> returnType1 = setAge.getReturnType();
//        System.out.println(returnType1);

        //方法的参数个数
        int parameterCount = getName.getParameterCount();
//        System.out.println(parameterCount);
        int parameterCount1 = setAge.getParameterCount();
//        System.out.println(parameterCount1);

        //方法的参数
        Parameter[] parameters = getName.getParameters();
        for (Parameter parameter : parameters) {
//            System.out.println(parameter);
        }
        Parameter[] parameters1 = setAge.getParameters();
        for (Parameter parameter : parameters1) {
//            System.out.println(parameter);
        }

        //返回方法的修饰符 是个整型数字 有多个修饰符的 相加
        /**
         * PUBLIC: 1
         * PRIVATE: 2
         * PROTECTED: 4
         * STATIC: 8
         * FINAL: 16
         * SYNCHRONIZED: 32
         * VOLATILE: 64
         * TRANSIENT: 128
         * NATIVE: 256
         * INTERFACE: 512
         * ABSTRACT: 1024
         * STRICT: 2048
         */
        int modifiers = getName.getModifiers();
//        System.out.println(modifiers);

        //获得方法上的注解
        Annotation[] annotations = getName.getAnnotations();
        for (Annotation annotation : annotations) {
//            System.out.println("annotation: "+annotation);
        }


        Method setName = c1.getMethod("setName", String.class);
        Method[] methods = c1.getMethods();
        Method[] methods1 = h.getMethods();
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for (Method method1 : methods) {
//            System.out.println(method1);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for (Method method : methods1) {
//            System.out.println(method);
        }
        Method method1 = c1.getMethod("setName", String.class);


        Field[] fields = c1.getDeclaredFields();
        Field field0 = fields[0];
        field0.setAccessible(true);
//        System.out.println(field1);
        for (Field field1 : fields) {
//            System.out.println(field);
//            String fieldName = field.getName();
//            System.out.println(fieldName);
        }


        Field[] declaredFields1 = h.getDeclaredFields();
        for (Field field : declaredFields1) {
        }
    }
}

class User {
    private int age;
    private static String name;
    private int height;

    public User() {
    }

    public User(int age, String name, int height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    private void setX() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Deprecated
    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}

