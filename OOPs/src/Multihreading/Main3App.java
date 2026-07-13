package Multihreading;

import java.util.LinkedList;
import java.util.Queue;


class SharedBuffer{
	private Queue<Integer>qu=new LinkedList<Integer>();
	private int capacity=5;
	
	public synchronized void produce(int val) throws InterruptedException {
		while(qu.size()==capacity) {
			wait();
		}
		qu.offer(val);
		System.out.println("Value produced "+val);
		notify();
	}
	
	public synchronized int consume() throws InterruptedException {
		while(qu.isEmpty()) {
			wait();
		}
		int val=qu.poll();
		System.out.println("Value consumed "+val);
		notify();
		return val;
	}
	
}
public class Main3App {
	public static void main(String[] args) {
		SharedBuffer sBuffer=new SharedBuffer();
		Thread t1=new Thread(()->{
			for(int i=1;i<=10;i++) {
				try {
					sBuffer.produce(i);
				}
				catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		Thread t2=new Thread(()->{
			for(int i=1;i<=10;i++) {
				try {
					sBuffer.consume();
				}
				catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
