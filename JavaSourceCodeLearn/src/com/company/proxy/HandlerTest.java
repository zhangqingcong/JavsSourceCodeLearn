package com.company.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HandlerTest implements InvocationHandler {
    private Object object;
    public HandlerTest(Object object){
       this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"增强前");
        method.invoke(object,args);
        System.out.println(method.getName()+"增强后");
        return null;
    }
}
