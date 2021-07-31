package com.sdut.case01;

public class BuyTicket implements Runnable{

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

    public void buy() throws InterruptedException {
        if (ticketNumbers <= 0){
            this.flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() +
                "拿到了" + ticketNumbers-- + "张票");
    }
}
