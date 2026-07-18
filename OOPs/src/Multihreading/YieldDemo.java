package Multihreading;

public class YieldDemo {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            for(int i=1;i<5;i++){
                System.out.println(Thread.currentThread().getName()+" prints "+i);
                Thread.yield();
            }
        },"thread-1");

        Thread t2=new Thread(()->{
            for(int i=1;i<5;i++){
                System.out.println(Thread.currentThread().getName()+" prints "+i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        },"thread-2");

        t1.start();
        t2.start();
    }
}
