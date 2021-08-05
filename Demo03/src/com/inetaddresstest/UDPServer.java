package com.inetaddresstest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) {

        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket = null;

        try {
            //开放端口
            datagramSocket = new DatagramSocket(8023);
            //接收数据包
            byte[] bytes = new byte[1024];
            datagramPacket =
                    new DatagramPacket(bytes,0,bytes.length);

            //阻塞接收
            datagramSocket.receive(datagramPacket);

            //输出发送主机的地址
            System.out.println(
                    datagramPacket.getAddress().getHostAddress());
            System.out.println(new java.lang.String(datagramPacket.getData(),0,datagramPacket.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (datagramSocket != null){
                datagramSocket.close();
            }
        }
    }
}
