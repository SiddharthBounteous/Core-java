package Multihreading.ThreadPool;

import java.util.concurrent.*;

public class Main {
    static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(2,4,10, TimeUnit.MINUTES,new ArrayBlockingQueue<>(2), new CustomThreadFactory(),new CustomRejectHandler());
        executor.allowCoreThreadTimeOut(true);  //then only keep alive can be used

        for(int i=1;i<=7;i++){
            executor.submit(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    //handle exception here
                }
                System.out.println("Task processed by: "+Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread t1= new Thread(r);
        t1.setPriority(Thread.NORM_PRIORITY);
        t1.setDaemon(false);
        return t1;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected: "+ r.toString());
    }
}
