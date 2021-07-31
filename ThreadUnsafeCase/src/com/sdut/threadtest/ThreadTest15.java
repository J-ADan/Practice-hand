package com.sdut.threadtest;

public class ThreadTest15 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Actor(tv).start();
        new Audience(tv).start();
    }
}

//表演者--生产者
class Actor extends Thread{
    Tv tv;

    public Actor(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(i %2 ==0){
                this.tv.show("钢管舞");
            }else{
                this.tv.show("皮皮虾广告（正片）");
            }
        }
    }
}

//观众--消费者
class Audience extends Thread{
    Tv tv;

    public Audience(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.tv.watch();
        }
    }
}

class Tv{
    String name;//节目名字
    //信号灯
    boolean flag = true;

    public synchronized void show(String name){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了" + name);
        //通知观众观看
        this.notifyAll();
        this.name = name;
        this.flag = !this.flag;
    }

    public synchronized void watch(){
        if (this.flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了" + name);
        //通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }
}