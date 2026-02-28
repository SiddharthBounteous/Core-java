package Multihreading.LockFreeMechanism;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {
    AtomicInteger counter=new AtomicInteger(0);

    public void increment(){
        counter.incrementAndGet();
    }

    public int get(){
        int a=counter.get();
        return a;
    }
}
