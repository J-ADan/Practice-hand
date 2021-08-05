package com.inetaddresstest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDown {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://rcode.zongheng.com/v2018/images/logo.png");
            //连接到资源
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

            //流下载
            InputStream inputStream = httpURLConnection.getInputStream();

            //文件下载
            FileOutputStream fileOutputStream = new FileOutputStream("logo.png");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,bytes.length);
            }

            fileOutputStream.close();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
