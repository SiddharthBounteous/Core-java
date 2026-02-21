package Multihreading;

public class MonitorLockExample {
    public synchronized  void task1(){
        try{
            System.out.println("inside task1");
            Thread.sleep(10000);
            System.out.println("task1 completed");
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void task2(){
        System.out.println("task2 but before synchronization");
        synchronized (this){
            System.out.println("task2 inside synchronization");
        }
    }
    public void task3(){
        System.out.println("task3");
    }

    public static void main(String[] args) {
        MonitorLockExample obj=new MonitorLockExample();

        //without lambda
        MontiorThread1 runnableobj=new MontiorThread1(obj);
        Thread t1=new Thread(runnableobj);

        Thread t2=new Thread(()-> {
            obj.task2();
        });
        Thread t3=new Thread(()-> {
            obj.task3();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
