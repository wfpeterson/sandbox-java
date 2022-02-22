package com.kinetix.sandbox.java.concurrency.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args){

        try{

            DatagramSocket socket = new DatagramSocket(9090);
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            while(true){
                DatagramPacket receivedPacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivedPacket);
                String sentence = new String(receivedPacket.getData());
                System.out.println("Received "+sentence);
                String stringData = "hello client!";
                sendData = stringData.getBytes();
                InetAddress clientIpAddress = receivedPacket.getAddress();
                int clientPort = receivedPacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIpAddress, clientPort);
                socket.send(sendPacket);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
