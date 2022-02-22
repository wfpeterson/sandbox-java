package com.kinetix.sandbox.java.concurrency.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args){

        try{
            DatagramSocket clientSocket = new DatagramSocket(0);
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            clientSocket.setSoTimeout(3000);;
            InetAddress serverAddress = InetAddress.getByName("localhost");
            String stringSendData = "Hello Server!";
            sendData = stringSendData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9090);
            clientSocket.send(sendPacket);
            DatagramPacket receivedPacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivedPacket);
            receiveData = receivedPacket.getData();
            String stringReceiveData = new String(receiveData);
            System.out.println("From Server: "+stringReceiveData);
            clientSocket.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
