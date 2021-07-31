package com.sdut.threadtest;

//继承Thread类
public class ThreadTest01 extends Thread{
    //重写Thread方法
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("多线程" + i);
        }
    }

    public static void main(String[] args) {
        //创建线程对象
        ThreadTest01 threadTest01 = new ThreadTest01();
        //调用strat() 方法
        threadTest01.run();

        for (int i = 0; i < 2000; i++) {
            System.out.println("主线程" + i);
        }
    }
}
