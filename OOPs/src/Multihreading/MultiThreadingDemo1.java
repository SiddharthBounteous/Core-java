package Multihreading;

public class MultiThreadingDemo1 {
    public static void main(String[] args) {
        System.out.println("Main Thread started");
        Thread t1=new Thread(()->{
            System.out.println("Hello from t1");
        });

        Runnable t2=new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from t2");
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread objRunnable=new Thread(t2,"Thread-t2");

        Runnable t3=()->{
            System.out.println("Thread-3 started");
            try {
                Thread.sleep(4000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("Thread 3 ended");
        };

        Thread objRunnableT3=new Thread(t3,"Thread-t3");

        t1.start();
        //t2.run();  //this does not create new thread
        //t3.run();
        objRunnableT3.setDaemon(true);
        objRunnable.start();
        objRunnableT3.start();

        System.out.println("Main Thread Ended");
    }
}
