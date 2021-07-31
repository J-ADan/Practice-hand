package com.sdut.synchronizedtest;

public class SynchronizedTest01 implements Runnable{
    private int ticketNumbers = 10;
    boolean flag = true;//外部控制线程停止

    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void buy() throws InterruptedException {
        if (ticketNumbers <= 0){
            this.flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() +
                "拿到了" + ticketNumbers-- + "张票");
    }

    public static void main(String[] args) {
        SynchronizedTest01 synchronizedTest01 = new SynchronizedTest01();

        new Thread(synchronizedTest01,"我").start();
        new Thread(synchronizedTest01,"你").start();
        new Thread(synchronizedTest01,"他").start();
    }
}


