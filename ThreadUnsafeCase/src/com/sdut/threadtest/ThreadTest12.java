package com.sdut.threadtest;

public class ThreadTest12 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                "..." + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        //获取主线程优先级，默认为5，且不可更改
        System.out.println(Thread.currentThread().getName() +
                "..." + Thread.currentThread().getPriority());

        ThreadTest12 threadTest12 = new ThreadTest12();
        Thread thread1 = new Thread(threadTest12);
        Thread thread2 = new Thread(threadTest12);
        Thread thread3 = new Thread(threadTest12);
        Thread thread4 = new Thread(threadTest12);
        Thread thread5 = new Thread(threadTest12);
        Thread thread6 = new Thread(threadTest12);

        thread1.setPriority(6);
        thread1.start();
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();
        thread3.setPriority(6);
        thread3.start();
        thread4.setPriority(Thread.NORM_PRIORITY);
        thread4.start();
        thread5.setPriority(Thread.MAX_PRIORITY);
        thread5.start();
        thread6.setPriority(6);
        thread6.start();

    }
}
