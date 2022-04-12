package com.mashibing.factory;

public class Car implements Moveable{
    @Override
    public void go(){
        System.out.println("the car is running...");
    }
}
