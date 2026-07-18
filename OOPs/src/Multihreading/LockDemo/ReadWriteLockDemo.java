package Multihreading.LockDemo;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedData{
    private int value=20;
    private final ReadWriteLock lock=new ReentrantReadWriteLock();

    public void readValue(){
        lock.readLock().lock();

        try{
            System.out.println(Thread.currentThread().getName()+" entering readValue, reading value "+value);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" leaving readValue, finished reading");
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally {
            lock.readLock().unlock();
        }
    }

    public void writeValue(int newValue){
        lock.writeLock().lock();

        try{
            System.out.println(Thread.currentThread().getName()+" entering writeValue, writing value "+newValue);
            Thread.sleep(2000);
            value=newValue;
            System.out.println(Thread.currentThread().getName()+" leaving writeValue, finished writing");
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally {
            lock.writeLock().unlock();
        }
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        SharedData sharedData=new SharedData();

        Thread reader1=new Thread(()->{
            sharedData.readValue();
        },"Reader-1");
        Thread reader2=new Thread(()->{
            sharedData.readValue();
        },"Reader-2");
        Thread writer1=new Thread(()->{
            sharedData.writeValue(10);
        },"Writer-1");

        Thread reader3=new Thread(()->{
            sharedData.readValue();
        },"Reader-3");

        Thread reader4=new Thread(()->{
            sharedData.readValue();
        },"Reader-4");

        reader1.start();
        reader2.start();
        writer1.start();
        reader3.start();
        reader4.start();
    }
}
