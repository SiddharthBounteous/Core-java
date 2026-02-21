package MulthreadingAssignment;

public class Main {
    static void main(String[] args) {
        SharedResource sharedBuffer=new SharedResource(5);

        //using lambda
        Thread producerThread=new Thread(()->{
            try{
                for(int i=1;i<=10;i++){
                    sharedBuffer.produce(i);
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        Thread consumerThread=new Thread(()->{
            try{
                for(int i=1;i<=10;i++){
                    sharedBuffer.consume();
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

        producerThread.start();
        consumerThread.start();

    }
}
