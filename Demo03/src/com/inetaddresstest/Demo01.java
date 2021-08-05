package com.inetaddresstest;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Demo01 implements Runnable{
    DatagramSocket datagramSocket = null;
    BufferedReader bufferedReader = null;
    private int fromPort;
    private String toIP;
    private int toPort;

    public Demo01(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            datagramSocket = new DatagramSocket(fromPort);
            bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true){
                String data = bufferedReader.readLine();
                byte[] bytes = data.getBytes();
                DatagramPacket datagramPacket =
                        new DatagramPacket
                                (bytes,0,bytes.length,new InetSocketAddress(this.toIP,this.toPort));

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
