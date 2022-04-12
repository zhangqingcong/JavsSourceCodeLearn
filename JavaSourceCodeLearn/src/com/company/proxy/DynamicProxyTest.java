package com.company.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        //把动态代理生成的.class文件保存下来
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //多态 持有一个被代理对象的引用
        HelloInterface hello = new Hello();

        HandlerTest handler = new HandlerTest(hello);

        HelloInterface proxyInstance = (HelloInterface) Proxy.newProxyInstance(Hello.class.getClassLoader(),
                Hello.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName()+"增强前");
                        method.invoke(hello,args);
                        System.out.println(method.getName()+"增强后");
                        return null;
                    }
                });
        proxyInstance.sayHello();
    }
}
