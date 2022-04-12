package com.company.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理类
public class HelloProxy implements HelloInterface{
    /**静态代理：
     * 代理类也实现了helloInterface接口 通过多态 持有一个被代理类的引用
     * 都实线相同的接口 就会都有接口中方法
     * 这样就完成了对另外一个类的代理操作
     * 但是如果需要被增强的被代理类很多 那就要为每一个被代理类生成一个代理类
     */
    private HelloInterface helloInterface = new Hello();
    @Override
    public void sayHello() {
        System.out.println("被代理类执行了");
        helloInterface.sayHello();
        System.out.println("被代理类执行之后");
    }

    public static void main(String[] args) {
//        HelloProxy proxy = new HelloProxy();
//        proxy.sayHello();

        Proxy.newProxyInstance(HelloProxy.class.getClassLoader(),
                new Class[]{HelloProxy.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        return null;
                    }
                });
    }
}
