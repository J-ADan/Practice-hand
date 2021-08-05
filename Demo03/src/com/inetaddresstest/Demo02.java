package com.inetaddresstest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo02 implements Runnable{
    DatagramSocket datagramSocket = null;
    private int port;
    private String fromname;

    public Demo02(int port, String fromname) {
        this.port = port;
        this.fromname = fromname;
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        try {

            while (true){

                //准备接收包裹
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length);
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                String datas = new String(data,0,data.length);
                System.out.println(fromname + ":" + datas);

                if (datas.equals("bye")){
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
