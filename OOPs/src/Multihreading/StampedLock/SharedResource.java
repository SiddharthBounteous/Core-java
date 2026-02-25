package Multihreading.StampedLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a=10;
//    boolean isAvailable=false;
    StampedLock lock=new StampedLock();

    public void producer(){
//        long stamp=lock.readLock();
        long stamp=lock.tryOptimisticRead();
        try{
            System.out.println("Take optimistic read");
            a=11;
//            System.out.println("Read lock acquired by: "+Thread.currentThread().getName());
//            isAvailable=true;
            Thread.sleep(8000);
            if(lock.validate(stamp)){
                System.out.println("Value updated successfully");
            }
            else{
                System.out.println("Rollback of work");
                a=10;
            }
        } catch (InterruptedException e) {

        }
//        finally {
//            lock.unlockRead(stamp);
//            System.out.println("Read lock released by: "+Thread.currentThread().getName());
//
//        }
    }

    public void consume(){
//        long stamp=lock.readLock();
        long stamp=lock.writeLock();
        System.out.println("Write lock acquired by: "+Thread.currentThread().getName());
        try{
//            System.out.println("Write lock acquired by: "+Thread.currentThread().getName());
//            isAvailable=false;
            System.out.println("Performing work");
            a=9;
        }
//        catch (Exception e) {
//
//        }
        finally{
            lock.unlockWrite(stamp);
            System.out.println("Write lock released by: "+Thread.currentThread().getName());
        }
    }
}
