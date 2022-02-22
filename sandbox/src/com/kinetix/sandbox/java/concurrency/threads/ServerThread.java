package com.kinetix.sandbox.java.concurrency.threads;

public class ServerThread extends Thread {

    public ServerThread(String threadName){
        this.setName(threadName);
    }
    public void run() {
        int clientNumber = 1;
        while(clientNumber != 100){
            System.out.println(this.getName()+" sent data to client: "+clientNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clientNumber++;
        }

    }
}
