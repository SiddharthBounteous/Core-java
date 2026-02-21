package MulthreadingAssignment;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer>sharedBuffer;
    private int bufferSize;

    public SharedResource(int bufferSize){
        sharedBuffer=new LinkedList<>();
        this.bufferSize=bufferSize;
    }

    public synchronized void produce(int item) throws Exception{

        //size is reached to max capacity
        while(sharedBuffer.size()==bufferSize){
            System.out.println("buffer is full. producer is waiting for consumer");
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("Produced: "+item);
        notify();
    }
    public synchronized int consume() throws Exception{
        //buffer is empty
        while(sharedBuffer.isEmpty()){
            System.out.println("buffer is empty. consumer is waiting for procuder");
            wait();
        }
        int item=sharedBuffer.poll();
        System.out.println("Consumed: "+item);
        notify();
        return item;
    }
}
