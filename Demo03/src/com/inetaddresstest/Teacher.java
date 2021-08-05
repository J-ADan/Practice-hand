package com.inetaddresstest;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new Demo01(8888,"127.0.0.1",7777)).start();
        new Thread(new Demo02(9999,"学生")).start();
    }
}
