package com.inetaddresstest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
    public static void main(String[] args) {
        InetAddress byName = null;
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            byName = InetAddress.getByName("127.0.0.1");
            int port = 8023;//端口号
            socket = new Socket(byName,port);
            fileInputStream = new FileInputStream(new File("jianbi.jpg"));
            outputStream = socket.getOutputStream();

            byte[] aByte = new byte[1024];
            int len;
            while ((len = fileInputStream.read(aByte)) != -1){
                outputStream.write(aByte,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
