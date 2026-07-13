package Multihreading;

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter{
    private int count=0;
//    private AtomicInteger count=new AtomicInteger(0);
    public void increment(){
//        count++;
//        count.incrementAndGet();

        //this means the current object of SharedCounter
        synchronized (this){
            count++;
        }
    }

    public int getCount(){
        return count;
//        return count.get();
    }
}
public class AtomicDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedCounter sharedCounter=new SharedCounter();

        //first the value is fetched from main memory to cache then increment operation is done inside register and assigning it back to i
        //Thread-1
        Thread t1=new Thread(()->{
            System.out.println("Thread-1 started");
            for(int i=0;i<5000;i++){
                sharedCounter.increment();
            }
            System.out.println("Thread-1 completed");
        });

        //Thread-2
        Thread t2=new Thread(()->{
            System.out.println("Thread-2 started");
            for(int i=0;i<5000;i++){
                sharedCounter.increment();
            }
            System.out.println("Thread-2 completed");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(sharedCounter.getCount());
    }
}
