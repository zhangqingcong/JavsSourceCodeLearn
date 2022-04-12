package com.mashibing.abstractfactory;

public class ModernFactory extends AbstractFactory{
    @Override
    Food creatFood() {
        return new Bread();
    }

    @Override
    Weapon creatWeapon() {
        return new AK47();
    }

    @Override
    Vehicle creatVehicle() {
        return new Car();
    }
}
