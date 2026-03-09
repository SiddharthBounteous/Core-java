package Multihreading.ScheduledTreadPool;

import java.util.concurrent.*;

public class Main3 {
    static void main(String[] args) {
        ScheduledExecutorService poolObj=Executors.newScheduledThreadPool(5);

        poolObj.schedule(()->{
            System.out.println("Hello");
        },5, TimeUnit.SECONDS);

        Future<?> futureObj=poolObj.scheduleAtFixedRate(()->{
            System.out.println("Hello from scheduled");
        },3,5, TimeUnit.SECONDS);

        try{
            Thread.sleep(10000);
            futureObj.cancel(true);
        }
        catch (Exception ex){

        }


        Future<String>obj=poolObj.schedule(()->{
            return "hello world";
        },5, TimeUnit.SECONDS);
        try{
            System.out.println(obj.get());
        }
        catch (Exception e){

        }
    }
}
