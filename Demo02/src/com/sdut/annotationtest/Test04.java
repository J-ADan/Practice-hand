package com.sdut.annotationtest;

import javax.sound.midi.Soundbank;

public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统的类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类-->根加载器(C/C++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //获取某个类的加载器
        ClassLoader classLoader = Class.forName
                ("com.sdut.annotationtest.Test04").getClassLoader();
        System.out.println(classLoader);

        //测试JDK内置类是由谁加载的
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        //获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        /*
        G:\Java\JDK\jdk1.8.0_131\jre\lib\charsets.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\deploy.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\access-bridge-64.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\cldrdata.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\dnsns.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\jaccess.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\jfxrt.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\localedata.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\nashorn.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\sunec.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\sunjce_provider.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\sunmscapi.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\sunpkcs11.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\ext\zipfs.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\javaws.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\jce.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\jfr.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\jfxswt.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\jsse.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\management-agent.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\plugin.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\resources.jar;
        G:\Java\JDK\jdk1.8.0_131\jre\lib\rt.jar;
        G:\Java\IDEA\WorkSpace\Demo02\out\production\Demo02;
        G:\Java\IDEA\IntelliJ IDEA 2019.3.5\lib\idea_rt.jar
         */
    }
}
