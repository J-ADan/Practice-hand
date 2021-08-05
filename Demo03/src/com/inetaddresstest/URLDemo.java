package com.inetaddresstest;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080//helloworld/index.html?username=jfc&password=123456");

            //获取协议
            System.out.println(url.getProtocol());
            //获取文件
            System.out.println(url.getPath());
            //获取端口
            System.out.println(url.getPort());
            //获取ip
            System.out.println(url.getHost());
            //获取文件的全路径
            System.out.println(url.getFile());
            //获取参数
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
