package com.company.test;



public class Demo02 {
    public static void main(String[] args){
        int y = 0;
        y=++y;
        y=++y;
        y=++y;
        y=++y;
        y=++y;
        System.out.println("y_"+y);
        int x = 0;
        //先赋值，后加一
        //x=0的值在寄存器中存着，而x++ x=x+1在内存中操作 但是在内存中操作并没有写到寄存器中
        //在获取x的值的时候还是获取的寄存器中的值，
        x=x++;//这一步操作等价与 x=x;然后x++ 等价于 x=x+1
        x=x++;
        x=x++;
        x=x++;
        x=x++;
        System.out.println("x_"+x);
        //若 a = i++; 则等价于 a=i;i=i+1;
        //而 a = ++i; 则等价于 i=i+1;a=i;
        int a = 0;
        int b = 0;
        a = a++ ;
        b = a++ ;
        //a=1是内存中自增1的结果所以a=1 a在寄存器里值依然为0 所以b=0
        System.out.println("a = " + a + ",b = " + b);//a = 1,b = 0 正确结果



    }
}
