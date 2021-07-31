package com.sdut.threadtest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTest08 implements Runnable {
    @Override
    public void run() {
        while (true){
            Date datetime = new Date(System.currentTimeMillis());//获取系统当前时间
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(datetime));
            try {
                Thread.sleep(1000);
                datetime = new Date(System.currentTimeMillis());//更新时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest08 threadTest08 = new ThreadTest08();

        new Thread(threadTest08).start();
    }
}
