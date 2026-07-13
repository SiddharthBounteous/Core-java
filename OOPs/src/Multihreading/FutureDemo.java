package Multihreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService=Executors.newSingleThreadExecutor();
		
		Callable<Integer>taskCallable=()->{
			Thread.sleep(3000);
			return 10+20;
		};
		
		Future<Integer>future=executorService.submit(taskCallable);
		
		System.out.println("Task submitted");

	    Integer result = future.get();

	    System.out.println("Result: " + result);

	    executorService.shutdown();
	}
}
