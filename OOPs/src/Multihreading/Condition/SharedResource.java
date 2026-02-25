package Multihreading.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable=false;
    ReentrantLock lock=new ReentrantLock();
    Condition condition= lock.newCondition();

    public void producer(){
        try{
            lock.lock();
            System.out.println("Producer lock acquired by: "+Thread.currentThread().getName());
            if(isAvailable){
                //already available , thread has to wait for it to consume
                System.out.println("Producer thread is waiting: "+Thread.currentThread().getName());
                condition.await();
            }
            isAvailable=true;
            condition.signal();
        } catch (Exception e) {

        }
        finally{
            lock.unlock();
            System.out.println("Producer lock release by: "+Thread.currentThread().getName());
        }
    }

    public void consume(){
        try{
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Consume lock acquired by: "+Thread.currentThread().getName());

            if(!isAvailable){
                //already not available , thread has to wait for it to produce
                System.out.println("Consumer Thread is waiting: "+Thread.currentThread().getName());
                condition.await();
            }
            isAvailable=false;
            condition.signal();
        } catch (Exception e) {

        }
        finally {
            lock.unlock();
            System.out.println("Consume lock release by: "+Thread.currentThread().getName());
        }
    }
}
