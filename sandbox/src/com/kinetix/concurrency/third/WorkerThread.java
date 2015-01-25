package com.kinetix.concurrency.third;

public class WorkerThread implements Runnable {

    private String command;
    private String strText = "Initial";
    
    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println("String Value for thread "+this.command+": "+ strText);
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setText(String str){
    	this.strText = str;
    }
    
    @Override
    public String toString(){
        return this.command;
    }
}
