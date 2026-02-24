package Multihreading;
public class Question1{
    static void main(String[] args) {
        static int check=1;
        Thread t1=new Thread(()->{
            for(int i=1;i<=100;i++){
                if(i%2==0){
                    System.out.println(i+" "+"printed by "+Thread.currentThread().getName());
                    check++;
                }
            }
        });
        Thread t2=new Thread(()->{
            for(int i=1;i<=100;i++){
                if(i%2==1){
                    System.out.println(i+" "+"printed by "+Thread.currentThread().getName());
                    check++;
                }
            }
        });
        t1.start();
        t2.start();

        System.out.println(check);
    }
}
