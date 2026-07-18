package Multihreading.LockDemo;

import java.util.concurrent.Semaphore;

class ParkingLot{
    private final Semaphore semaphore=new Semaphore(2);

    public void parkCar(){
       try{
           System.out.println(Thread.currentThread().getName()+" waiting for parking");

           semaphore.acquire();

           System.out.println(Thread.currentThread().getName()+" parked the car");

           Thread.sleep(3000);

           System.out.println(Thread.currentThread().getName() + " leaving parking");
       } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
       }
       finally {
           semaphore.release();
       }
    }
}
public class SemaphoreDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot=new ParkingLot();

        for(int i=1;i<=5;i++){
            Thread t=new Thread(parkingLot::parkCar,"Car-"+i);
            t.start();
        }
    }
}
