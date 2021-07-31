package com.sdut.threadtest;

public class ThreadTest13 {
    public static void main(String[] args) {
        Person person = new Person();
        God god = new God();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认值为false，如果不设置，即为用户线程
        thread.start();

        new Thread(person).start();

    }
}

class Person implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("开心的活着!");
        }
        System.out.println("再见世界!");
    }
}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝一直都在!");
        }
    }
}