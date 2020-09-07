package com.kinetix.concurrency.fifth;

import java.util.concurrent.Callable;

public class MoveTask implements Callable<Void> {

	public MoveTask() {
		
	}

	@Override
	public Void call() throws Exception {
				
		Thread.currentThread();
		Thread.sleep(5000);
		System.out.println("MoveTask Thread is done.");
		return null;
	}
}
