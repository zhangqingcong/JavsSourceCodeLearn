package com.company.reflection;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;

//测试Class类的创建方式有哪些
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+person.name);
        List arrList = new ArrayList();
        System.out.println(arrList);
        //方法一，通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1);

        Class<? extends List> c02 = arrList.getClass();
        System.out.println(c02);
        //方法二，通过forName获得
        Class<?> c2 = Class.forName("com.company.reflection.Student");
        System.out.println(c2);
        Class<?> c = Class.forName("java.util.List");
        System.out.println(c.hashCode());


        //方法三，通过类名.class
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass);
        Class<List> listClass = List.class;
        System.out.println(listClass);

        //方式四：基本内置类型的包装类都有一个Type属性 可以通过type属性获得Class对象
        Class<Integer> c4 = Integer.TYPE;
        Class<Integer> integerClass = Integer.class;
        System.out.println(integerClass);
        System.out.println(c4 );
        Class<Byte> type = Byte.TYPE;
        System.out.println(type);
        System.out.println(Short.TYPE);
        System.out.println(Long.TYPE);
        System.out.println(Double.TYPE);
        System.out.println(Float.TYPE);
        System.out.println(Boolean.TYPE);
        System.out.println(Character.TYPE);

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
        Class<? super Integer> superclass = c4.getSuperclass();
        System.out.println(superclass);


    }

}
class Person{
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
}