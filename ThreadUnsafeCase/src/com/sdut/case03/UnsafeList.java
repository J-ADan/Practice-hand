package com.sdut.case03;

import java.util.ArrayList;
import java.util.List;

//集合不安全案例
public class UnsafeList {

    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(
                    ()->{
                        objects.add(Thread.currentThread().getName());
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
