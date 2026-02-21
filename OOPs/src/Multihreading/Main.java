package Multihreading;

public class Main {
    static void main(String[] args) {
        SharedResource sharedResource=new SharedResource();
        Thread producerTread=new Thread(()->{
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResource.addItem();
        });

        Thread consumerThread=new Thread(()->{
            sharedResource.consumeItem();
        });
        producerTread.start();
        consumerThread.start();
    }
}
