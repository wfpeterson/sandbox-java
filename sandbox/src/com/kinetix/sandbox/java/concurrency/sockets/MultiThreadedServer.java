package com.kinetix.sandbox.java.concurrency.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {

    public static void main(String[] args){

        try {
            ServerSocket serverSocket = new ServerSocket(9091);
            boolean stop = false;
            while(!stop){
                System.out.println("waiting for clients...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client is connected...");
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
