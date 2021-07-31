package com.sdut.threadtest;

//模拟网络延迟
public class ThreadTest06 implements Runnable {
    private int num = 10;

    @Override
    public void run() {
        while (num <= 10) {
            if (num < 0){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + num-- + "张票");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ThreadTest06 threadTest061 = new ThreadTest06();

        new Thread(threadTest061, "小明").start();
        new Thread(threadTest061, "老师").start();
        new Thread(threadTest061, "黄牛").start();
    }
}
