package Multihreading.ScheduledTreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main2 {
    static void main(String[] args) throws InterruptedException {
        ExecutorService poolObj= Executors.newFixedThreadPool(5);
        poolObj.submit(()->{
            try{
                Thread.sleep(15000);
            }
            catch (Exception e){

            }
            System.out.println("New task");
        });

        poolObj.shutdownNow();

        boolean isTerminated=poolObj.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("is Terminated: "+isTerminated);

        System.out.println("main thread unlocked and finished processing");
        System.out.println("is Terminated: "+isTerminated);
    }
}
