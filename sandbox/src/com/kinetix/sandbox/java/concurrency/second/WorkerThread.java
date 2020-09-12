package com.kinetix.sandbox.java.concurrency.second;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class WorkerThread implements Runnable {

    private String command;
    private String filename;
    private FileFudgeHandler handler;
    
    public WorkerThread(String s, FileFudgeHandler fileHandler){
        this.command=s;
        this.handler = fileHandler;
    }

    public void setFile(String filename){
    	this.filename = filename;
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        while(true){
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	processCommand();
            System.out.println(Thread.currentThread().getName()+" End.");
        }
    }

    private void processCommand() {
        try {
        	if(filename != null){
	        	System.out.println("opening inputstream from inside thread.");
	            FileInputStream fis = new FileInputStream(this.filename);
	            InputStream is = fis;
	            handler.fileStreamHandler(is);
	            fis.close();
	            filename = null;
        	}
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
	@Override
    public String toString(){
        return this.command;
    }
}
