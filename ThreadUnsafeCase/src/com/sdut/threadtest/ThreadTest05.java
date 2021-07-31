package com.sdut.threadtest;


//不建议使用 stop方法，以及destroy方法
//自己设置标志位
public class ThreadTest05 implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        while (flag){
            System.out.println("一直在跑");
        }
    }

    public void stop(boolean flag){
        this.flag = flag;
    }

    public static void main(String[] args) {
        ThreadTest05 threadTest05 = new ThreadTest05();

        new Thread(threadTest05).start();
        for (int i = 0; i < 500; i++) {
            System.out.println("主线程" + i);
            if (i == 456){
                threadTest05.stop(false);
                System.out.println("线程停止");
            }
        }
    }
}
