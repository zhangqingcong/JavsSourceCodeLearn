package com.company.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//练习反射操作注解
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.company.reflection.Student2");


        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解的value的值
        Tablestuden tablestuden = (Tablestuden) c1.getAnnotation(Tablestuden.class);
        String value = tablestuden.value();
        System.out.println(value);

        //获得类指定的注解
        Field name = c1.getDeclaredField("name");
        FieldStudent nameAnnotation = name.getAnnotation(FieldStudent.class);
        String nameColumnName = nameAnnotation.columnName();
        String nameType = nameAnnotation.type();
        int nameLength = nameAnnotation.length();
        System.out.println(nameColumnName);
        System.out.println(nameType);
        System.out.println(nameLength);

        //获取类指定的注解
        Field id = c1.getDeclaredField("id");
        FieldStudent idAnnotation = id.getAnnotation(FieldStudent.class);
        String idType = idAnnotation.type();
        String idColumnName = idAnnotation.columnName();
        int idLength = idAnnotation.length();
        System.out.println(idType);
        System.out.println(idColumnName);
        System.out.println(idLength);

        //获取类指定的注解
        Field age = c1.getDeclaredField("age");
        FieldStudent ageAnnotation = age.getAnnotation(FieldStudent.class);
        String ageType = ageAnnotation.type();
        String ageColumnName = ageAnnotation.columnName();
        int ageLength = ageAnnotation.length();
        System.out.println(ageType);
        System.out.println(ageColumnName);
        System.out.println(ageLength);
    }
}
@Tablestuden("db_student")
class Student2{
    @FieldStudent(columnName = "db_id",type = "int",length = 10)
    private int id;
    @FieldStudent(columnName = "db_age", type = "int",length = 10)
    private int age;
    @FieldStudent(columnName = "db_name",type = "varchar",length = 3)
    private String name;
    public Student2(){

    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablestuden{
    String value();
}
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldStudent{
    String columnName();
    String type();
    int length();
}