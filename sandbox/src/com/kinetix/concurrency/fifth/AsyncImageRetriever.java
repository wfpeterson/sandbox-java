package com.kinetix.concurrency.fifth;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncImageRetriever {

	public AsyncImageRetriever() {
		
	}
	
	public InputStream RetrieveImage(String uid){
		InputStream stream = null;
		
		Future<InputStream> future = ScpListener.getInstance().asyncRetrieveImage(uid);
		
        try {
			stream = future.get(5000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
     
        return stream;
	}
}
