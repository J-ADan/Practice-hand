package com.sdut.threadtest;

//龟兔赛跑
public class ThreadTest03 implements Runnable{

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("兔子")){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (gameOver(i)){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    public boolean gameOver(int steps){
        if (winner != null){
            return true;
        }{
            if (steps >= 100){
                winner = Thread.currentThread().getName();
                System.out.println(winner + "赢了");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreadTest03 threadTest03 = new ThreadTest03();

        new Thread(threadTest03,"兔子").start();
        new Thread(threadTest03,"乌龟").start();
    }
}
