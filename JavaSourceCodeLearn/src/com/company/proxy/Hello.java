package com.company.proxy;
//被代理类
public class Hello implements HelloInterface{

    /**
     * 专注于业务 只干一件事
     */
    @Override
    public void sayHello() {
        System.out.println("hello 接口");
    }
}
