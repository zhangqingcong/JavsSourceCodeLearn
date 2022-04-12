package com.company.annotation;

import java.lang.annotation.*;
@MyAnnotation(value = 3,name = "小李")
@MyAnnotation0(0)//没有默认值，使用的时候必须写出值 name=value的格式 不成文规定如果 如果自定义注解中只有一个
//且这个参数名是value，在使用注解时可以省略参数名
//@MyAnnotation2("a") 这个自定义注解的作用域是方法METHOD 所以没有办法用在类上 只能注解在方法上
@MyAnnotation4(name = 4)
public class Demo01 {

    void testMethod(){

    }
    @MyAnnotation2("加法")
    int add(int a,int b){
        return a + b ;
    }

//    @MyAnnotation3这个自定义注解的作用域是TYPE 所以没办法作用在方法上
    int mul(int x, int y){
        return x*y;
    }
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation4{
    int name();
}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{
    int value() default 2;
    String name() default "";
}

@interface MyAnnotation0{
    int value();
}


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String value();
}
//作用域在方法上的自定义注解 有默认值
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    int a() default 1;
    int b() default 2;
    int c();
}