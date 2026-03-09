package Multihreading.ThreadLocal;

public class Main1 {
    static void main(String[] args) {
        ThreadLocal<String>threadLocalObj=new ThreadLocal<>();

        //main
        threadLocalObj.set(Thread.currentThread().getName());

        Thread t1=new Thread(()->{
           threadLocalObj.set(Thread.currentThread().getName());
            System.out.println("Task1");
        });

        t1.start();
        try{
            Thread.sleep(2000);
        }
        catch (Exception e){

        }

        //main thread
        System.out.println("Main thread: "+threadLocalObj.get());
    }
}
