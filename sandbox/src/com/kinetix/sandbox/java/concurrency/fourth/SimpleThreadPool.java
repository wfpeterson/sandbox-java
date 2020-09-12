package com.kinetix.sandbox.java.concurrency.fourth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
		
	public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
            WorkerThread worker = new WorkerThread("Secondary Thread");
            executor.execute(worker);
	    	for (int i=0; i<6; i++){
	            try {
		        	worker.setText("Sleep "+ i);
		            Thread.sleep(3000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
	    	}

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        
        while (!executor.isTerminated()) {
        	System.out.println("Waiting for termination");
        }
        System.out.println("Finished thread");
	}
}
