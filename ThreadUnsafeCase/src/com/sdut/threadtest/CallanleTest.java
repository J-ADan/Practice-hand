package com.sdut.threadtest;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class CallanleTest implements Callable<Boolean> {
    private String url;
    private String name;
    @Override
    public Boolean call() throws Exception {
        DownLoadTest05 downLoadTest = new DownLoadTest05();
        downLoadTest.downLoad(url,name);
        System.out.println("下载了" + name);
        return true;
    }
    public CallanleTest(String url,String name){
        this.url = url;
        this.name = name;
    }

    public static void main(String[] args) throws ExecutionException,InterruptedException {
        CallanleTest t1 = new CallanleTest("https://img-blog.csdnimg.cn/img_convert/27ab07360d9fdff5877982c0c1dfd917.png","01.png");
        CallanleTest t2 = new CallanleTest("https://img-blog.csdnimg.cn/img_convert/27ab07360d9fdff5877982c0c1dfd917.png","02.png");
        CallanleTest t3 = new CallanleTest("https://img-blog.csdnimg.cn/img_convert/27ab07360d9fdff5877982c0c1dfd917.png","03.png");

        ExecutorService ser = Executors.newFixedThreadPool(3);

        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);

        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();

        ser.shutdownNow();
    }
}
class DownLoadTest05 {
    //下载方法
    public void downLoad(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载器异常");
        }
    }
}