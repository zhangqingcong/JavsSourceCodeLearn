package com.itheima.InnerClass;

/**
 * 内部类就是定义在一个类里面的类，里面的类可以理解成寄生，外部类可以理解成宿主
 */
public class StaticClass {
    static private String name;
    Integer age;

    /**
     * 静态内部类
     * 有static修饰 属于外部类本身
     * 使用和普通类完全一致，类的成分它都有，只是位置在别人里面
     */
    public static class Inner{

        String name;
        Integer age;
        static long weight;
        public void test(){
        
        }
        private void test2(){

        }
        public static void test3(){

        }
        public Inner() {
        }

        public Inner(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    /**
     * 成员内部类
     * 是类的一个成员
     */
    public class Inner1{

    }


}
