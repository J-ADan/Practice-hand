package com.sdut.threadtest;


//多线程同时操作一个对象
public class ThreadTest implements Runnable{

    private int ticketNums = 0;
    @Override
    public void run() {

        while (true){
            if (ticketNums >= 100){
                break;
            }
            if (ticketNums == 10){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "拿到了" + ticketNums++ + "张票");
        }

    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();

        System.out.println(Thread.currentThread().getName());
        new Thread(threadTest,"a1").start();
        new Thread(threadTest,"a2").start();
        new Thread(threadTest,"a3").start();
        new Thread(threadTest,"a4").start();
        new Thread(threadTest,"a5").start();
        new Thread(threadTest,"a6").start();
        new Thread(threadTest,"a7").start();
        new Thread(threadTest,"a8").start();
        new Thread(threadTest,"a9").start();
        new Thread(threadTest,"a10").start();
    }
}
