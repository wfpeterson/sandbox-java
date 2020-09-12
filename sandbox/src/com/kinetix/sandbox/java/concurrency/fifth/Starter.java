package com.kinetix.sandbox.java.concurrency.fifth;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Starter {

	public Starter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.execute(ScpListener.getInstance());
        
        try {
			Thread.currentThread();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        String uid = "1.2.3";
        AsyncImageRetriever retriever = new AsyncImageRetriever();
        InputStream stream = retriever.RetrieveImage(uid);
        
        try {
			Thread.currentThread();
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
	}

}
