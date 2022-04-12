package com.mashibing.factory;

/**
 * 任意定制生产过程
 * Moveable XXXFactory.create();
 */
public class CarFactory {
    public Moveable createCar(){
        System.out.println("a car is creating");
        return new Car();
    }
}
