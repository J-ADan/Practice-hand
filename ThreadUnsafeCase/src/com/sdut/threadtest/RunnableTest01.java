package com.sdut.threadtest;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class RunnableTest01 implements Runnable{

    private String url;
    private String name;

    @Override
    public void run() {
        DownLoadTest downLoadTest = new DownLoadTest();
        downLoadTest.downLoad(url,name);
        System.out.println("下载了" + name);
    }

    public RunnableTest01(String url,String name){
        this.url = url;
        this.name = name;
    }

    public static void main(String[] args) {
        ThreadTest02 t1 = new ThreadTest02("https://img-blog.csdnimg.cn/img_convert/27ab07360d9fdff5877982c0c1dfd917.png","01.png");
        ThreadTest02 t2 = new ThreadTest02("https://img-blog.csdnimg.cn/img_convert/27ab07360d9fdff5877982c0c1dfd917.png","02.png");
        ThreadTest02 t3 = new ThreadTest02("https://img-blog.csdnimg.cn/img_convert/27ab07360d9fdff5877982c0c1dfd917.png","03.png");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

class DownLoadTest01{
    //下载方法
    public void downLoad(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载器异常");
        }
    }
}
