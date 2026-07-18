package Multihreading.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo1 {
    public static void main(String[] args) {
        //interrupt() does not forcefully kill a thread.
        //It sends a stop/request signal by setting interrupted status.
        //interrupt means: One thread is sending a signal/request to another thread: “Please stop what you are doing” or "wake up if you are waiting"
        ExecutorService ex1= Executors.newFixedThreadPool(3);

        for(int i=0;i<6;i++){
            int taskId=i;  //now it is effectively final
            ex1.submit(()->{
                System.out.println("Hello world printed (loop 1) "+taskId+" "+Thread.currentThread().getName());
            });
        }
//        ex1.shutdownNow();
        for(int i=0;i<6;i++){
            int taskId=i;
            ex1.submit(()->{
                System.out.println("Hello world printed by (loop 2) "+taskId+" "+Thread.currentThread().getName());
            });
        }

        ex1.shutdown();
    }
}
