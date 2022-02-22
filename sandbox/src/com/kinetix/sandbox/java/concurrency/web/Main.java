package com.kinetix.sandbox.java.concurrency.web;

import com.kinetix.sandbox.java.concurrency.ftp.Client;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args){

        try{
            ServerSocket serverSocket = new ServerSocket(80);
            boolean isStop = false;
            while(!isStop){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client "+clientSocket.getInetAddress().getHostAddress()+"is connected.");
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();


            }

        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
