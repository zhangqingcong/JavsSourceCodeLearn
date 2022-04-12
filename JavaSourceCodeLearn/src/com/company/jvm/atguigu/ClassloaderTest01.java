package com.company.jvm.atguigu;

import com.sun.net.ssl.internal.ssl.Provider;
import sun.misc.Launcher;
import sun.misc.URLClassPath;
import sun.security.ec.CurveDB;

import java.net.URL;

public class ClassloaderTest01 {
    public static void main(String[] args) {
        System.out.println("启动类加载器");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL );
        }
        //从上面的路径中随意选择一个类，来看看他的类加载器是什么：null Bootstrap Classloader
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println("********扩展类加载器******");
        String extDirs = System.getProperty("java.ext.dirs");
        String[] paths = extDirs.split(":");
        for (String path : paths) {
            System.out.println(path);
        }
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1);
    }
}
