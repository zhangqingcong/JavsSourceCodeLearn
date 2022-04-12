package com.company.jvm.atguigu;

public class ClassloaderTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层 拓展类加载器
        ClassLoader extClassloader = systemClassLoader.getParent();
        System.out.println(extClassloader);//sun.misc.Launcher$ExtClassLoader@5e481248

        //获取其上层
        ClassLoader bootstrapClassLoader = extClassloader.getParent();
        System.out.println(bootstrapClassLoader);//null

        //对于用户自定义类来说：默认使用系统加载器进行加载
        ClassLoader classLoader = ClassloaderTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2


        //java的核心类库都是使用引导类加载器进行加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
