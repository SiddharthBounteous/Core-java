package Java8Features;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        List<Integer>numbers= IntStream.rangeClosed(1,16).boxed().toList();

        //parallelStream() internally uses Java's ForkJoinPool (specifically the common pool). The collection provides a Spliterator, which recursively splits the data into smaller chunks. These chunks are wrapped into Fork/Join tasks and submitted to the ForkJoinPool. Worker threads process the chunks in parallel using the work-stealing algorithm, and finally the framework combines the partial results to produce the final output.
        List<Integer>result=numbers.parallelStream().map(x->x*2).toList();

        for(int i=0;i< result.size();i++){
            System.out.print(result.get(i)+" ");
        }
        System.out.println();
    }
}
