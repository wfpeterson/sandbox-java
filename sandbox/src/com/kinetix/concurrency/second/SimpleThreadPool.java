package com.kinetix.concurrency.second;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool implements FileFudgeHandler {
		
	int count = 0;
	
	
	public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //for (int i = 0; i < 10; i++) {
        SimpleThreadPool starter = new SimpleThreadPool();
        WorkerThread worker = new WorkerThread("worker", starter);
        executor.execute(worker);
        //}
        worker.setFile("toBill.txt");
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        worker.setFile("BillLog.txt");
        
        //executor.shutdown();
        
        //while (!executor.isTerminated()) {
        
        //}
        //System.out.println("Finished all threads");
	}
	
    @Override
	public void fileStreamHandler(InputStream in) {
    	
    	File file = new File("test"+count+".dcm");
        try {
        	System.out.println("storing inputstream to new file from outside of thread.");
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
