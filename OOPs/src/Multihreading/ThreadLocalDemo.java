package Multihreading;

public class ThreadLocalDemo {
	public static void main(String[] args) {
		ThreadLocal<Long>userIdThreadLocal=new ThreadLocal<Long>();
		
		//simulate a user landing on the web page
		Long userId=12345L;
		Long userId1=56789L;
		
		//handle the request in a new thread
		Thread requestThread=new Thread(()->{
			System.out.println("Started thread for "+userIdThreadLocal.get());
			userIdThreadLocal.set(userId);
			System.out.println("Started logic for " + userIdThreadLocal.get());
			//process the logic
			//database call
			//good practice to remove threadlocal object
			
			System.out.println("Completed logic for "+userIdThreadLocal.get());
			userIdThreadLocal.remove();
			System.out.println("Removed "+userIdThreadLocal.get());
		});
		
		Thread requestThread1=new Thread(()->{
			System.out.println("Started thread for "+userIdThreadLocal.get());
			userIdThreadLocal.set(userId1);
			//process the logic
			//database call
			//good practice to remove threadlocal object
			System.out.println("Started logic for " + userIdThreadLocal.get());
			
			System.out.println("Completed logic for "+userIdThreadLocal.get());
			userIdThreadLocal.remove();
			System.out.println("Removed "+userIdThreadLocal.get());
		});
		
		requestThread.start();
		requestThread1.start();
		
		InheritableThreadLocal<String>inheritableThreadLocal=new InheritableThreadLocal<String>();
		
		 Thread objThread3=new Thread(()->{
			 inheritableThreadLocal.set("instagram");
			 userIdThreadLocal.set(12345678L);
			 
			 Thread objThread4=new Thread(()->{
				 System.out.println(inheritableThreadLocal.get());
				 System.out.println(userIdThreadLocal.get());
			 });
			 objThread4.start();
		 });
		 
		 objThread3.start();
	}
}
