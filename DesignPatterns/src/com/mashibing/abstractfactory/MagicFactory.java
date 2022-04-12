package com.mashibing.abstractfactory;

public class MagicFactory extends AbstractFactory{
    @Override
    Food creatFood() {
        return new MushRoom();
    }

    @Override
    Weapon creatWeapon() {
        return new MagicStick();
    }

    @Override
    Vehicle creatVehicle() {
        return new Broom();
    }
}
