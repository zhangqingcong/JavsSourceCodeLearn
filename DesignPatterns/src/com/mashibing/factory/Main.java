package com.mashibing.factory;

public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        Plane p = new Plane();
//        car.go();
//        Moveable p = new Broom();
//        p.go();

        Moveable m = new CarFactory().createCar();
        m.go();
    }
}
