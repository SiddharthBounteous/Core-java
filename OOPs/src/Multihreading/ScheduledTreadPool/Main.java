package Multihreading.ScheduledTreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static void main(String[] args) {
        ExecutorService poolObj= Executors.newFixedThreadPool(5);
        poolObj.submit(()->{
            System.out.println("Thread going to start its work");
        });

        poolObj.shutdown();

        //will give exception
        poolObj.submit(()->{
            System.out.println("Thread going to start its work");
        });
    }
}
