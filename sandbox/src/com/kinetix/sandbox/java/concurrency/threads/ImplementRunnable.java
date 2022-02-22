package com.kinetix.sandbox.java.concurrency.threads;

public class ImplementRunnable implements Runnable {

    private int threadIndex;
    public ImplementRunnable(int index) {
        this.threadIndex = index;
    }

    @Override
    public void run() {
        int clientNumber = 1;
        while(clientNumber != 100){
            System.out.println("Server"+this.threadIndex+" sent data to client: "+clientNumber);
            clientNumber++;
        }

    }

    public void start(){
        Thread thread = new Thread(this);
        thread.start();
    }
}
