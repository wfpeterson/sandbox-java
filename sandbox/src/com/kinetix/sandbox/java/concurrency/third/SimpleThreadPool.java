package com.kinetix.sandbox.java.concurrency.third;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
		
	public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            WorkerThread worker = new WorkerThread("" + i);
            executor.execute(worker);
            if(i > 5){
            	worker.setText("Changed");
            }
        }
        
        executor.shutdown();
        
        while (!executor.isTerminated()) {
        
        }
        System.out.println("Finished all threads");
	}
}
