package Multihreading.Condition;

public class Main {
    static void main(String[] args) {
        SharedResource resource=new SharedResource();
        Thread t1=new Thread(()->{
            for(int i=0;i<2;i++){
                resource.producer();
            }
        });
        Thread t2=new Thread(()->{
            for(int i=0;i<2;i++){
                resource.consume();
            }
        });

        t1.start();
        t2.start();
    }
}
