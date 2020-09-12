package com.kinetix.sandbox.java.concurrency.fifth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MoveSCU {
	
	ExecutorService executor = Executors.newFixedThreadPool(1);
	
	public MoveSCU() {
		
	}
	
	public Future<Void> moveRequest(String uid){
		Future<Void> future = null;
		
		MoveTask task = new MoveTask();
		future = executor.submit(task);
		System.out.println("MoveTask thread started.");
		
		
		return future;
	}

}
