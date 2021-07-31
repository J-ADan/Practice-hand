package com.sdut.threadtest;

public class ThreadTest11 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程结束");
        });

        Thread.State state = thread.getState();
        System.out.println(state); //NEW

        thread.start();
        state = thread.getState();
        System.out.println(state);//Runnable

        while (state != Thread.State.TERMINATED){//只要线程不停止，一直监听状态

            Thread.sleep(100);
            state = thread.getState();//更新状态
            System.out.println(state);

        }
    }
}
