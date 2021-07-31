package com.sdut.synchronizedtest;

public class SynchronizedTest04 {
    public static void main(String[] args) {
        change change1 = new change(0,"我");
        change change2 = new change(1,"你");
        change1.start();
        change2.start();
    }
}
class Mirror{

}
class Lipstick{

}

class change extends Thread{
    static Mirror mirror = new Mirror();
    static Lipstick lipstick = new Lipstick();

    int choise;
    String name;
    public change(int choise, String name){
        this.choise = choise;
        this.name = name;
    }


    @Override
    public void run() {
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void makeUp() throws InterruptedException {
        if (this.choise == 0){
            synchronized (mirror){
                System.out.println(this.name + "获得镜子");
                Thread.sleep(1000);
                synchronized (lipstick){
                    System.out.println(this.name + "获得口红");
                }
            }
        }else {
            synchronized (lipstick){
                System.out.println(this.name + "获得口红");
                synchronized (mirror){
                    System.out.println(this.name + "获得镜子");
                }
            }
        }
    }
}