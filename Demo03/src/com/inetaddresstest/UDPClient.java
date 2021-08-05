package com.inetaddresstest;

import java.io.IOException;
import java.net.*;
import java.nio.channels.DatagramChannel;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            //建立一个Socket
            datagramSocket = new DatagramSocket();
            //建个包
            String msg = "我爱你啊";
            InetAddress inetAddress =InetAddress.getByName("127.0.0.1");
            int port = 8023;

            //数据，数据的长度的起始，数据要发送给谁
            DatagramPacket datagramPacket =
                    new DatagramPacket
                            (msg.getBytes(),0,msg.getBytes().length,inetAddress,port);

            datagramSocket.send(datagramPacket);
        } catch (SocketException | UnknownHostException e) {
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
