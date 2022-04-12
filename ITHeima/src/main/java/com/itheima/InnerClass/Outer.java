package com.itheima.InnerClass;

/**
 * 学习内部类
 *  1、静态内部类
 *  2、成员内部类
 *  3、局部内部类
 *  4、匿名内部类
 */
public class Outer {
    /**
     * 什么是内部类
     *  顾名思义 内部类就是定义在一个类里面的类，里面的类可以理解成 寄生 外部类可以理解成宿主
     *  public class People{
     *      //内部类
     *      public class Heart{
     *
     *      }
     *  }
     *
     *  内部类的作用、使用场景
     *  当一个事物的内部，还有一个部分需要一个完整的结构进行描述，而这个内部的完整的结构又只为外部事物提供服务，
     *  那么整个内部的完整结构可以选择使用内部类来设计。
     *
     * 内部类通常可以方便访问外部类的成员，包括私有的成员。
     *
     * 内部类提供了更好的封装性，内部类本身就可以用private protectecd等修饰，封装性可以做更多控制。
     *
     */
    /**
     * 什么是静态内部类
     *  有static修饰 属于外部类本身
     *  内部类提供了更好的封装性，内部类本身就可以用private protectecd等修饰，封装性可以做更多控制。
     */
    //外部类的静态变量
    public static int a = 100;
    //外部类的私有成员变量
    private String hobby;

    /**
     * 静态内部类
     */
    public static class Inner{
        private String name;
        private int age;
        public static String schoolName;

        public Inner(){}

        public Inner(String name, int age) {
            this.name = name;
            this.age = age;
        }
         public void show(){
             System.out.println(name);
             System.out.println(a);//静态内部类可以直接访问外部类的静态成员
//             System.out.println(hobby); 编译就报错 不可以直接访问外部类的实例成员
             Outer outer = new Outer();
             System.out.println(outer.hobby);
         }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public static String getSchoolName() {
            return schoolName;
        }

        public static void setSchoolName(String schoolName) {
            Inner.schoolName = schoolName;
        }
    }

}
