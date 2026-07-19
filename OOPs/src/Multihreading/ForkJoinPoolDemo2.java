package Multihreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class FindMaximum extends RecursiveTask<Integer>{
    private int [] data;
    private int start;
    private int end;
    private static final int THRESHOLD=4;

    public FindMaximum(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread().getName()+ " -> start=" + start+ ", end=" + end+ ", length=" + (end - start));
        int length=end-start;
        if(length<=THRESHOLD){
            return computeDirectly();
        }
        else{
            int mid=start+length/2;

            FindMaximum left=new FindMaximum(data,start,mid);
            FindMaximum right=new FindMaximum(data,mid,end);

            // Pushes the task onto the current worker's deque.
            left.fork();  //another idle worker thread can steal it and execute it

            // Instead of forking both tasks, the current worker immediately
            // computes the right task itself. This keeps the current thread busy
            // and avoids the overhead of creating and scheduling another task.
            int rightResult=right.compute();

            // Waits for the left task to finish (if it hasn't already).
            // If another worker completed it, join() returns immediately.
            // Otherwise, the current worker waits (or may help execute pending tasks).
            int leftResult=left.join();
            return Math.max(leftResult,rightResult);
        }
    }

    private Integer computeDirectly(){
        int max=Integer.MIN_VALUE;
        for(int i=start;i<end;i++){
            max=Math.max(max,data[i]);
        }
        return max;
    }
}
public class ForkJoinPoolDemo2 {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=ForkJoinPool.commonPool();
        int[] data = {1, 4, 2, 7, 5, 3, 18, 6, 9, 0, 12, 14, 16};
        FindMaximum task=new FindMaximum(data,0,data.length);
        int result=forkJoinPool.invoke(task);  //submit task to call compute internally
        System.out.println("Maximum number is: "+result);
    }
}
