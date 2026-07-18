package Multihreading.LockDemo;

class SharedPrinter{
    public synchronized void print(String message){
        System.out.println(Thread.currentThread().getName()+" entered");

        for(int i=1;i<=3;i++){
            System.out.println(Thread.currentThread().getName()+" prints: "+message+" "+i);

            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
               Thread.currentThread().interrupt();
            }
        }

        System.out.println(Thread.currentThread().getName()+" exiting");
    }
}
public class MonitorLockDemo {
    public static void main(String[] args) throws InterruptedException{
        SharedPrinter sharedPrinter=new SharedPrinter();

        Thread t1=new Thread(()->{
            sharedPrinter.print("hello");
        },"Thread-1");

        Thread t2=new Thread(()->{
            sharedPrinter.print("That's me");
        },"Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
