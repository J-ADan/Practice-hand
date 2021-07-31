package com.sdut.threadtest;

public class RunnableTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("多线程" + i);
        }
    }

    public static void main(String[] args) {
        //船舰Runnable接口实现类对象
        RunnableTest runnableTest = new RunnableTest();

        //丢入Runnable的对象
        Thread thread = new Thread(runnableTest);
        //通过start开启线程
        thread.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("主线程" + i);
        }

    }
}
