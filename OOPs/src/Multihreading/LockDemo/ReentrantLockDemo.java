package Multihreading.LockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class SharedCounter{

    ReentrantLock lock=new ReentrantLock();
    public void method1(){
        lock.lock();

        try{
            System.out.println(Thread.currentThread().getName()+ " entered method 1");
            System.out.println("Hold count on method 1 "+lock.getHoldCount());
            method2();  //same thread tries to gain same lock again
            System.out.println(Thread.currentThread().getName()+ " exiting method 1");
        }
        finally{
            lock.unlock();  //unlock from method 1
            System.out.println("Unlock from method 1");
        }
    }

    public void method2(){
        lock.lock();

        try{
            System.out.println(Thread.currentThread().getName()+ " entered method 2");
            System.out.println(lock.getHoldCount());
            System.out.println(Thread.currentThread().getName()+ " exiting method 2");
        }
        finally{
            lock.unlock();  //unlock from method 2
            System.out.println("Unlock from method 2");
        }
    }

}
class TryLockExample{
    ReentrantLock lock=new ReentrantLock();

    public void accessResource(){
        try{
            if(lock.tryLock(1, TimeUnit.SECONDS)){
                try{
                    System.out.println(Thread.currentThread().getName() + " got the lock");

                    Thread.sleep(3000);

                    System.out.println(Thread.currentThread().getName() + " completed work");
                }
                finally {
                    lock.unlock();
                }
            }
            else{
                System.out.println(Thread.currentThread().getName()+ " couldn't get lock, doing something else");
            }
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
public class ReentrantLockDemo {
    public static void main(String[] args) {
        SharedCounter sharedCounter=new SharedCounter();
        TryLockExample tryLockExample=new TryLockExample();

//        Thread t1=new Thread(()->{
//           sharedCounter.method1();
//        },"Thread-1");
//
//        t1.start();

        Thread t2=new Thread(()->{
           tryLockExample.accessResource();
        },"Thread-2");

        Thread t3=new Thread(()->{
           tryLockExample.accessResource();
        },"Thread-3");

        t2.start();
        t3.start();
    }
}
