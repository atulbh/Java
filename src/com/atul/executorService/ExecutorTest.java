package com.atul.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

	public static void main(String[] args) {
		// a thread pool uses a blocking queue 
		
		//create a fixed thread pool
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for(int i =0;i< 100;i++) {
			executorService.execute(new Task());
		}
		
		//get no of processros 
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("cores :: "+cores);
		
		// create a cached pool
		ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
		
	}
}

class Task implements Runnable{

	@Override
	public void run() {

			System.out.println("Thread Name :: "+ Thread.currentThread().getName());
	}
	
	
}

// what is ideal pool size? 
// In case of CPU intensive operation, ideal pool size is equal to no of cores. 
// if there are more threads than no of cores then it will do time based splitting. Though we should consider 
// the fact that if other application(critical) are running on same machine, it is possible that 
// you won't even get all cores. 

//In case of IO intensive operation, ideal pool size should be high, as IO operation like 
// DB calls, HTTPS calls, Network calls takes time and processor might be sitting idle.
// but consider the fact that too many threads will take too much memory. 


