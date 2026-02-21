package Multihreading;

//if not using lambda
public class MontiorThread1 implements  Runnable{

    MonitorLockExample obj;

    public MontiorThread1(MonitorLockExample obj) {
        this.obj = obj;
    }

    @Override
    public void run(){
        obj.task1();
    }
}
