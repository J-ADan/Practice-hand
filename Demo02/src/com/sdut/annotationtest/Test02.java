package com.sdut.annotationtest;

public class Test02 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}

class A{
    static {
        System.out.println("类的静态块");
        m = 300;
    }
    static int m = 100;

    public A() {
        System.out.println("类的无参构造方法");
    }
}