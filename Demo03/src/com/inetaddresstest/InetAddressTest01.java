package com.inetaddresstest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest01 {
    public static void main(String[] args) {
        //查询本机地址
        try {
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);
            InetAddress inetAddress2 = InetAddress.getByName("localhost");
            System.out.println(inetAddress2);
            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3);

            //查询网站的IP地址
            InetAddress inetAddress4 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress4);

            //常用的方法
            byte[] address = inetAddress4.getAddress();
            System.out.println(address);

            //获取规范的名字
            String canonicalHostName = inetAddress4.getCanonicalHostName();
            System.out.println(canonicalHostName);

            //获取IP
            String hostAddress = inetAddress4.getHostAddress();
            System.out.println(hostAddress);

            //获取域名
            String hostName = inetAddress4.getHostName();
            System.out.println(hostName);

            //获取自己电脑名字
            System.out.println(inetAddress2.getHostName());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
