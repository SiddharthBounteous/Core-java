package Multihreading;


class SharedResourceDemo{
    private volatile boolean flag=false;  //now thread-2 will directly read the latest value from main memory

    public void setFlag(boolean flag){
        this.flag=flag;
    }

    public boolean getFlag(){
        return flag;
    }
}
public class VolatileKeywordDemo {
    public static void main(String[] args) throws Exception{
        SharedResourceDemo sharedResourceDemo=new SharedResourceDemo();

        //Thread-1
        new Thread(()->{
            System.out.println("Thread 1 started");
            try{
                System.out.println("Thread-1 logic started");
                Thread.sleep(2000);
                System.out.println("Thread-1 logic ended");
                sharedResourceDemo.setFlag(true);
                System.out.println("Flag set by thread-1 to true");
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }).start();

        //Thread-2
        new Thread(()->{
            System.out.println("Thread-2 started");
            while(!sharedResourceDemo.getFlag()){
                //it will run until the flag is true
                //visibility problem will be there if not using volatile
            }
            System.out.println("Thread-2 completed");
        }).start();

    }
}
