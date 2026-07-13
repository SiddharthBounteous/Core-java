package Multihreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
	public static void main(String[] args) {
		ExecutorService executorService= Executors.newFixedThreadPool(3);
		
		for(int i=1;i<=5;i++) {
			int taskId=i;
			executorService.submit(()->{
				System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
			});
		}
		executorService.shutdown();
	}
}
