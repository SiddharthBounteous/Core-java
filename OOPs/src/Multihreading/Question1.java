package Multihreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Question1{
    static void main(String[] args) throws InterruptedException {
        AtomicInteger check = new AtomicInteger(0);
        Thread t1=new Thread(()->{
            for(int i=1;i<=100;i++){
                if(i%2==0){
                    System.out.println(i+" "+"printed by "+Thread.currentThread().getName());
                    check.incrementAndGet();
                }
            }
        });
        Thread t2=new Thread(()->{
            for(int i=1;i<=100;i++){
                if(i%2==1){
                    System.out.println(i+" "+"printed by "+Thread.currentThread().getName());
                    check.incrementAndGet();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(check);
    }
}
