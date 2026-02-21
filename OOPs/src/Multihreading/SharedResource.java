package Multihreading;

public class SharedResource {
    boolean isItemPresent=false;

    //puts lock
    public synchronized void addItem(){
        isItemPresent=true;
        System.out.println("Producer Thread calling the notify method");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consumer Thread is inside consumer item method");
        while(!isItemPresent){
            try{
                System.out.println("Consumer Thread is waiting");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Consumer Thread completed");
        isItemPresent=false;
    }
}
