package Java8Features;

import java.util.function.Function;

public class MainApp3 {
    public static void main(String[] args)
    {
        // Function to find square of a number using anonymous class
        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        /*  andThen() → execute current function first, then another function.
            compose() → execute another function first, then current function.*/
        Function<Integer,Integer>square1=x->x*x;
        Function<Integer, Integer> doubleValue = x -> x * 2;
        Function<Integer, Integer> squareThenDouble = square.andThen(doubleValue);

        // Test numbers
        System.out.println("Square of 5 : " + square.apply(5));
        System.out.println("Square of 9 : " + square1.apply(9));
        System.out.println(squareThenDouble.apply(4));
        System.out.println(square1.compose(doubleValue).apply(4));
    }
}
