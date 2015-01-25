package com.kinetix.concurrency.fifth;

import java.io.InputStream;
import java.util.concurrent.Callable;

public class ImageReceiveTask implements Callable<InputStream> {

	InputStream stream = null;
	
	public ImageReceiveTask() {
		
	}

	@Override
	public InputStream call() throws Exception {
		
		System.out.println("ImageReceiveTask thread started.");
		//while(this.stream == null){
		Thread.currentThread();
		Thread.sleep(1000);
		//}
		//return this.stream;
		System.out.println("ImageReceiveTask thread is done.");
		return null;
	}
	
	public void setImageStream(InputStream stream){
		this.stream = stream;
	}
}
