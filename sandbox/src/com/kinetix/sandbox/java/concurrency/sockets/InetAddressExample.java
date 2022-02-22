package com.kinetix.sandbox.java.concurrency.sockets;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

    public static void main(String[] args){

        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
            InetAddress address2 = InetAddress.getByName("google.com");
            System.out.println(address2.getHostAddress());
            System.out.println(address2.getHostName());




        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
