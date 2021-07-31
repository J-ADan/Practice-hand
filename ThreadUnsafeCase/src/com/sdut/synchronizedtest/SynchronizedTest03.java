package com.sdut.synchronizedtest;

import java.util.ArrayList;

public class SynchronizedTest03 {
    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(
                    ()->{
                        synchronized (objects){
                            objects.add(Thread.currentThread().getName());
                        }
                    }
            ).start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(objects.size());
    }
}
