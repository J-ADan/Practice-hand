package com.inetaddresstest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPPerson01 {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(8023);
            while (true){


                //准备数据，控制台读取
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(System.in));

                String data = bufferedReader.readLine();
                byte[] bytes = data.getBytes();
                DatagramPacket datagramPacket =
                        new DatagramPacket
                                (bytes,0,bytes.length,new InetSocketAddress("127.0.0.1",9999));

                datagramSocket.send(datagramPacket);

                if (data.equals("bye")){
                    break;
                }
            }
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
