package Multihreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class MonitorLockDemo {
	private final ReentrantLock lock = new ReentrantLock();
	public void test() {
//		lock.lock();
		
		try {
			if(lock.tryLock(1,TimeUnit.SECONDS)) {
				try {
		        	System.out.println(Thread.currentThread().getName() + " entered test");
		            Thread.sleep(3000);
		            System.out.println(Thread.currentThread().getName() + " exiting test");
		        } catch (InterruptedException e) {
		            Thread.currentThread().interrupt();
		        }
		        finally {
		        	lock.unlock();
				}
			}
			else {
				System.out.println(Thread.currentThread().getName()+" waited but couldn't get lock");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}

public class MainApp{
	public static void main(String[] args) {
		MonitorLockDemo m1=new MonitorLockDemo();
		MonitorLockDemo m2=new MonitorLockDemo();
		
		Thread t1=new Thread(()-> m1.test(),"Thread-1-m1");
		Thread t2=new Thread(()->m1.test(),"Thread-2-m1");
		Thread t3=new Thread(()->m2.test(),"Thread-3-m2");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
