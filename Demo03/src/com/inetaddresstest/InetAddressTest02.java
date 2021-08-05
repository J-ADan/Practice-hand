package com.inetaddresstest;

import java.net.InetSocketAddress;
import java.sql.SQLOutput;

public class InetAddressTest02 {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress =
                new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress inetSocketAddress2 =
                new InetSocketAddress("localhost",8080);
        System.out.println(inetSocketAddress);
        System.out.println(inetSocketAddress2);

        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getPort());
    }
}
