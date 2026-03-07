package Multihreading.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String args[]){
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        Future<?>futureObj=poolExecutor.submit(()->{
            try{
                Thread.sleep(7000);
                System.out.println("This is the task, which thread will execute");
            }
            catch (Exception ex){

            }
        });

        System.out.println("is Done: "+futureObj.isDone());
        try{
            futureObj.get(2,TimeUnit.SECONDS);
        }
        catch (TimeoutException ex){
            System.out.println("TimeOut Exception happened");
        }
        catch (Exception ex){

        }

        try{
            futureObj.get();
        }
        catch (Exception e){

        }

        System.out.println("is Done: "+futureObj.isDone());
        System.out.println("is Cancelled: "+futureObj.isCancelled());

        List<Integer>li=new ArrayList<>();
        Future<List<Integer>> futureObject=poolExecutor.submit(new MyRunnable(li),li);

        try {
            futureObject.get();
            System.out.println(li.get(0));

            List<Integer>result=futureObject.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        //callable
        Future<List<Integer>>futureObj1=poolExecutor.submit(()->{
            List<Integer>output=new ArrayList<>();
            output.add(300);
            return output;
        });

        try{
            List<Integer>result=futureObj1.get();
            System.out.println(result.get(0));
        }
        catch (Exception ex){

        }

        try {


            ThreadPoolExecutor poolExecutor1 = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                return "Task Completed";
            }, poolExecutor1);

            System.out.println(asyncTask1.get());
        } catch (Exception e) {

        }

        CompletableFuture<String> completableFuture1=CompletableFuture.supplyAsync(()->{
            try{
                System.out.println("Thread name of current thread: "+Thread.currentThread().getName());
                Thread.sleep(5000);
            }
            catch(Exception e){

            }
            return "CONCEPT";
        },poolExecutor);

        CompletableFuture<String>completableFuture2=completableFuture1.thenApply((String val)->{
            System.out.println("Thread Name of then apply: "+Thread.currentThread().getName());
            return "AND";
        });



    }
}
