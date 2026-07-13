package Multihreading;

class OddEven{
	private  int num=0;
	private  int limit=10;
	public synchronized void printOdd() {
		while(num<=limit) {
			if(num%2==1) {
				System.out.println(num+" ");
				num++;
				notify();
			}
			else {
				try {
					wait();
				}
				catch (InterruptedException e) {
					 Thread.currentThread().interrupt();
				}
			}
		}
	}
	
	public synchronized void printEven() {
		while(num<=limit) {
			if(num%2==0) {
				System.out.println(num+" ");
				num++;
				notify();
			}
			else {
				try {
					wait();
				}
				catch (InterruptedException e) {
					 Thread.currentThread().interrupt();
				}
			}
		}
	}
}
public class MainApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddEven obj=new OddEven();
		Thread t1=new Thread(()->obj.printEven());
		Thread t2=new Thread(obj::printOdd);
		
		t1.start();
		t2.start();
	}

}
