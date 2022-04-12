package com.mashibing.abstractfactory;

public class Main {
    public static void main(String[] args) {

//        Car car = new Car();
//        car.go();
//        AK47 weapon = new AK47();
//        weapon.shoot();
//        Bread bread = new Bread();
//        bread.printName();

        AbstractFactory f= new ModernFactory();
        Vehicle vehicle = f.creatVehicle();
        vehicle.go();
        Food food = f.creatFood();
        food.printName();
        Weapon weapon = f.creatWeapon();
        weapon.shoot();
    }
}
