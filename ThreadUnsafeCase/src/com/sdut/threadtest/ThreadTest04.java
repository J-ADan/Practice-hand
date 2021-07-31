package com.sdut.threadtest;

public class ThreadTest04 implements Runnable{
    private final Object lock = new Object();

    private String s[] = new String[]{"a","b","c","d","e","f"};
    private int n[] = new int[]{1,2,3,4,5,6};

    @Override
    public void run() {
           for (String s1 : s){
               synchronized (lock){
                   try {
                       System.out.print(s1);
                       lock.notify();
                       lock.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        for (int n1 : n){
            synchronized (lock){
                try {
                    System.out.print(n1);
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ThreadTest04 t1 = new ThreadTest04();
        ThreadTest04 t2 = new ThreadTest04();

        new Thread(t1).start();
        Thread.sleep(1000);
        new Thread(t2).start();
    }
}
