package com.itheima.d9_lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo03 {
    public static void main(String[] args) {
        Integer[] ages1 = {34,12,42,23};
//        Arrays.sort(ages1, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        Arrays.sort(ages1,(Integer o1,Integer o2)->{
//            return o2-o1;
//        });
        //1、可以省略参数类型
//        Arrays.sort(ages1,(o1,o2)->{
//            return o2-o1;
//        });
        //4、若方法体代码只有一行代码 且有返回值，那么 省略{}的同时必须省略return
        //        Arrays.sort(ages1,o1,o2)-> o2-o1); 两个 连个以上的参数是不能省略()的否则会报错 应为无法区分第一参数是给匿名内部类的还是原方法调用的
        Arrays.sort(ages1,(o1,o2)-> o2-o1);

        System.out.println(Arrays.toString(ages1));
        System.out.println("---------------------");
        JFrame win = new JFrame("登陆页面");
        JButton btn = new JButton("我是一个很大的按钮");
//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println("有人点我，点我，点我！！");
//            }
//        });


//        btn.addActionListener((ActionEvent e)->{
//            System.out.println("有人点我，点我，点我！！");
//        });
        //2、只有一个参数 可以省略参数类型 和括号()
//        btn.addActionListener(e->{
//            System.out.println("只有一个参数的时候可以省略()");
//        });

        //3、方法体只有一行代码 可以省略{} 和方法结束后面的 ; 这个方法必须是不带返回的
        btn.addActionListener(e-> System.out.println("只有一行代码体的时候的省略"));
        win.add(btn);
        win.setSize(400,300);
        win.setVisible(true);

    }
}
