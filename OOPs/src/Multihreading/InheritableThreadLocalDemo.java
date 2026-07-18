package Multihreading;

public class InheritableThreadLocalDemo {
	public static void main(String[] args) {
		InheritableThreadLocal<String>inheritableThreadLocal=new InheritableThreadLocal<String>();
		
		 Thread objThread3=new Thread(()->{
			 inheritableThreadLocal.set("instagram");
			 System.out.println("thread 3 thread value "+inheritableThreadLocal.get());
			 
			 
			 Thread objThread4=new Thread(()->{
				 System.out.println("Child thread value (thread 4) "+inheritableThreadLocal.get());
			 });
			 objThread4.start();
		 });
		 
		 objThread3.start();
		 
		 
	}
}
