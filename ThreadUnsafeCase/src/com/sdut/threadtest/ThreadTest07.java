package com.sdut.threadtest;

//模拟倒计时
public class ThreadTest07 implements Runnable {
    private int num = 10;
    @Override
    public void run() {
        while (true){
            if (num <= 0){
                break;
            }
            System.out.println(num--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest07 threadTest07 = new ThreadTest07();

        new Thread(threadTest07).start();
    }
}
