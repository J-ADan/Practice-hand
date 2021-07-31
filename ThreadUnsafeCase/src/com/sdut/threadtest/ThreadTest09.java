package com.sdut.threadtest;

//线程的礼让，但是礼让不一定成功
public class ThreadTest09 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程启动");
        Thread.yield();//线程的礼让
        System.out.println(Thread.currentThread().getName() + "线程结束");
    }

    public static void main(String[] args) {
        ThreadTest09 threadTest09 = new ThreadTest09();

        new Thread(threadTest09,"a").start();
        new Thread(threadTest09,"b").start();
    }
}
