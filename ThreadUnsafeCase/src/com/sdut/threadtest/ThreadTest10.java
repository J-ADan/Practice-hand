package com.sdut.threadtest;

//线程的强制执行，可以理解为找关系插队
public class ThreadTest10 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程VIP" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest10 threadTest10 = new ThreadTest10();
        Thread thread = new Thread(threadTest10);

        thread.start();
        //主线程，被插队
        for (int i = 0; i < 500; i++) {
            System.out.println("main" + i);
            if ( i == 200){
                thread.join();
            }
        }
    }
}
