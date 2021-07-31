package com.sdut.threadtest;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest16 implements Runnable{
    @Override
    public void run() {
        System.out.println("线程池中的第" + Thread.currentThread().getName() + "个线程");
    }

    public static void main(String[] args) {
        ThreadTest16 threadTest16 = new ThreadTest16();
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(threadTest16);
        service.execute(threadTest16);
        service.execute(threadTest16);
        service.execute(threadTest16);
        service.execute(threadTest16);
        //关闭连接
        service.shutdown();
    }
}
