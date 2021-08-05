package com.inetaddresstest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            //1.服务器得有一个地址
            serverSocket = new ServerSocket(8023);
            //2.等待客户端连接
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();

            //利用管道流接收信息
            fileOutputStream = new FileOutputStream(new File("02.jpg"));
            byte[] aByte = new byte[1024];
            int len;
            while ((len = inputStream.read(aByte)) != -1){
                fileOutputStream.write(aByte,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (accept != null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
