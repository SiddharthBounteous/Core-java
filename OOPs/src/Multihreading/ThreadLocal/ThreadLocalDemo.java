package Multihreading.ThreadLocal;

public class ThreadLocalDemo {
	static int value=0;
	static ThreadLocal<Integer> value1=new ThreadLocal<Integer>();
	public static void main(String[] args) {
		//without thread local
		Thread t1 = new Thread(() -> {
            value = 10;
            value1.set(10);
            System.out.println("Thread 1: " + value);
            System.out.println("Thread 1: "+ value1.get());
        });

        Thread t2 = new Thread(() -> {
            value = 20;
            value1.set(20);
            System.out.println("Thread 2: " + value);
            System.out.println("Thread 2: "+ value1.get());
        });

        t1.start();
        t2.start();

	}

}
