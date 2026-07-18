package Multihreading.LockDemo;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

class Point{
    private int x=0;
    private int y=0;

    private final StampedLock stampedLock=new StampedLock();

    public void move(int newX,int newY){
        long stamp=stampedLock.writeLock();

        try{
            System.out.println(Thread.currentThread().getName()+" writing");
            x=newX;
            y=newY;
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" completed writing");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public void distanceFromOrigin(){
        long stamp=stampedLock.tryOptimisticRead();

        int currentX=x;
        int currentY=y;

        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if(!stampedLock.validate(stamp)){
            System.out.println(Thread.currentThread().getName()+" Optimistic Read failed, taking read lock");
            stamp=stampedLock.readLock();

            try{
                currentX=x;
                currentY=y;
            }
            finally {
                stampedLock.unlockRead(stamp);
            }
        }
        else{
            System.out.println(Thread.currentThread().getName() + " optimistic read successful");
        }
        double distance=Math.sqrt(currentX * currentX + currentY * currentY);
        System.out.println(Thread.currentThread().getName()+ " distance: " + distance);
    }
}
public class StampedLockDemo {
    public static void main(String[] args) {
        Point point = new Point();

        Thread reader1=new Thread(point::distanceFromOrigin, "Reader-1");
        Thread writer=new Thread(() -> point.move(3, 4), "Writer");
        Thread reader2=new Thread(point::distanceFromOrigin, "Reader-2");

        reader1.start();
        writer.start();
        reader2.start();
    }
}
