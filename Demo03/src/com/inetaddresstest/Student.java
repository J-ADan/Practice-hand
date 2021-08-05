package com.inetaddresstest;

public class Student {
    public static void main(String[] args) {
        new Thread(new Demo01(6666,"127.0.0.1",9999)).start();
        new Thread(new Demo02(7777,"老师")).start();
    }
}
