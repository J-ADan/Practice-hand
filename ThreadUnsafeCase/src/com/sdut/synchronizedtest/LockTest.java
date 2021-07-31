package com.sdut.synchronizedtest;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {
    private int ticketNumbers = 10;
    boolean flag = true;//外部控制线程停止
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (flag) {
            try {
                lock.lock();//加锁
                try {
                    buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();//解锁
            }
        }
    }

    public void buy() throws InterruptedException {
        if (ticketNumbers <= 0) {
            this.flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() +
                "拿到了" + ticketNumbers-- + "张票");
    }

    public static void main(String[] args) {
        LockTest buyTicket = new LockTest();

        new Thread(buyTicket,"我").start();
        new Thread(buyTicket,"你").start();
        new Thread(buyTicket,"他").start();
    }
}
