package com.kinetix.sandbox.java.concurrency.fifth;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ScpListener implements Runnable{

	private static ScpListener instance= null;
	
	private Map<String, Future<InputStream>> futureMap = null;
	private Map<String, ImageReceiveTask> taskMap = null;
	
	ExecutorService executor = Executors.newFixedThreadPool(5);
	
	private ScpListener() {
		futureMap = new HashMap<String, Future<InputStream>>();
		taskMap = new HashMap<String, ImageReceiveTask>();
	}
	
	public static ScpListener getInstance(){
		if(instance == null){
			instance = new ScpListener();
		}
		return instance;
	}

	@Override
	public void run() {
		System.out.println("SCP Listener Thread started.");
		while(true){
			String uid = "1.2.3";
			InputStream stream = null;
			if(!taskMap.isEmpty()){
				ImageReceiveTask task = taskMap.get(uid);
				task.setImageStream(stream);
				System.out.println("ImageReceiveTask: "+task.toString());
			}
			
			try {
				Thread.currentThread();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Future<InputStream> asyncRetrieveImage(String uid){
		System.out.println("asyncRetrieveImage method called.");
		Future<InputStream> handle = this.getHandle(uid);
		futureMap.put(uid, handle);		
		
		MoveSCU scu = new MoveSCU();
		scu.moveRequest(uid);
		
		return handle;
	}
	
	
	private Future<InputStream> getHandle(String uid) {
        Future<InputStream> future = null;

        ImageReceiveTask task = new ImageReceiveTask();
        future = executor.submit(task);
        taskMap.put(uid, task);
        
        return future;
    }
}
