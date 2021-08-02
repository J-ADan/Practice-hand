package com.sdut.annotationtest;

public class Test03 {
    static {
        System.out.println("Main被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //类的主动引用的情况
        System.out.println("1.");
        //1. new一个类的对象
        Son son = new Son();

        System.out.println("2.");
        //2.调用类的静态成员
        int n = Son.m;

        System.out.println("3.");
        //3. 反射调用
        Class aClass = Class.forName("com.sdut.annotationtest.Son");

        System.out.println("****************************");
        //类的被动引用
        System.out.println("1.");
        int n1 = Son.b;

        System.out.println("2.");
        //数组定义引用
        Son[] sons = new Son[10];

        System.out.println("3.");
        //引用常量
        int n3 = Son.a;
    }
}

class Father{
    static  int b = 1;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
    }

    static int m = 100;
    static final int a = 1;
}