package com.company.reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //根据系统类加载器的父类加载器--->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器--->根加载器（c/c++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试自己编写的类是由哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.company.reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        //测试JDK内置的类是谁加载的
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        /**
         *
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/charsets.jar:
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/deploy.jar:
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/ext/dnsns.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/ext/jaccess.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/ext/localedata.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/ext/nashorn.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/ext/sunec.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/ext/zipfs.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/javaws.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/jce.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/jfr.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/jfxswt.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/jsse.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/management-agent.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/plugin.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/resources.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/jre/lib/rt.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/lib/ant-javafx.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/lib/dt.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/lib/javafx-mx.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/lib/jconsole.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/lib/packager.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/lib/sa-jdi.jar:
         *  /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/lib/tools.jar:
         *  /Users/zhangmingming/IdeaProjects/JavaSourceCodeLearn/out/production/JavaSourceCodeLearn:
         *  /Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar
         */

    }
}
