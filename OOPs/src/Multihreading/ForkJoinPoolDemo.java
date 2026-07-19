package Multihreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

//RecursiveAction is used when a task does not return any result.
/*
* Fork/Join provides two abstract classes:
* 1. RecursiveAction  -> void return type
* 2. RecursiveTask<T>  -> Returns a value
* */
class UpperCaseAction extends RecursiveAction {

    private List<String> names;

    //without threshold,tasks would keep splitting until they contained a single element, creating huge overhead.
    private static final int THRESHOLD=4;

    public UpperCaseAction(List<String>names){
        this.names=names;
    }

    //Whenever the pool executes a task, it calls compute()
    @Override
    protected void compute() {
        System.out.println(Thread.currentThread().getName()+" -> size "+names.size()+ " -> "+ names);
        if(names.size()>THRESHOLD){
            int mid=names.size()/2;
            UpperCaseAction task1=new UpperCaseAction(names.subList(0,mid));
            UpperCaseAction task2=new UpperCaseAction(names.subList(mid,names.size()));

            //Internally, invokeAll forks both tasks and waits until they both complete.
            invokeAll(task1,task2);
        }
        else{
            process();
        }
    }

    private void process(){
        for(int i=0;i<names.size();i++){
            names.set(i,names.get(i).toUpperCase());
        }
    }
}
public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=ForkJoinPool.commonPool();
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Edward", "Frank", "George", "Henry", "Irene", "John");
        UpperCaseAction action=new UpperCaseAction(names);
        forkJoinPool.invoke(action);  //internally do action.compute()

        for(int i=0;i<names.size();i++){
            System.out.print(names.get(i)+" ");
        }
        System.out.println();

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
        //The work is divided into tasks, not assigned permanently to threads.
        //Any worker thread can execute any available task.
        //If a worker becomes idle, it can execute or steal another pending task to improve CPU utilization.

        //by default: parallelism = availableProcessors() - 1
    }
}
