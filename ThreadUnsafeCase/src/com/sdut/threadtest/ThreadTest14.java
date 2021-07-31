package com.sdut.threadtest;

public class ThreadTest14{
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        new Producer(buffer).start();
        new Consumer(buffer).start();
    }
}
//缓冲区
class Buffer{
    //容器大小
    Product[] products = new Product[10];
    int count = 0;
    //生产者放入产品
    public synchronized void push(Product product){
        if (count == products.length){
            //如果容器满了，通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果没有满，生产
        products[count] = product;
        count++;

        this.notifyAll();
    }

    //消费者取出产
    public synchronized Product pop(){
        //判断能否消费
        if (count == 0){
            //消费者等待，通知生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Product product = products[count];


        this.notifyAll();
        return product;
    }

}
//消费者
class Consumer extends Thread{
    Buffer buffer;
    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("消费了" + buffer.pop().id);
        }
    }
}
//生产者
class Producer extends Thread{
    Buffer buffer;
    public Producer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("生产第" + i);
            buffer.push(new Product(i));
        }
    }
}

class Product{
    int id;

    public Product(int id) {
        this.id = id;
    }
}