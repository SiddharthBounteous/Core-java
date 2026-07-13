package Multihreading;

public class MultiThreadingDemo2 {
    public static Object sharedObject=new Object();  //This is stored in heap as it is shared by both threads
    public static void main(String[] args) {
        Runnable obj1=()->{
            System.out.println("Thread-1 started");
            System.out.println(sharedObject.hashCode());
            int runnable1=0;  //local variable limited to thread 1
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread-1 ended");
        };

        Runnable obj2=()->{
            System.out.println("Thread-2 started");
            System.out.println(sharedObject.hashCode());
            int runnable2=0;  //local variable limited to thread 2
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread-2 ended");
        };

        Thread t1=new Thread(obj1,"Thread-1");
        Thread t2=new Thread(obj2,"Thread-2");

        t1.start();
        t2.start();
    }
}
