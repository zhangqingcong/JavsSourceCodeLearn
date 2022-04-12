package com.mashibing.factory;

/**
 * 简单的工厂模式
 * 缺点是可扩展性不好,新添加一个工厂的时候就要新写一段代码
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        //before dosomething
        return new Car();
    }
    public Broom createBroom(){
        //before ......
        return new Broom();
    }
}
