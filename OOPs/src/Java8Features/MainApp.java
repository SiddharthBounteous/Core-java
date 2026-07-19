package Java8Features;

import java.util.function.Predicate;

public class MainApp
{
    public static void main(String[] args)
    {
        // Predicate to check if a number is even using anonymous class
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };

        // Test numbers
        System.out.println("Is 4 is even : " + isEven.test(4));
        System.out.println("Is 7 is even : " + isEven.test(7));

        Predicate<Integer> isEven1 = x -> x % 2 == 0;

        // Test numbers
        System.out.println("Is 4 even? " + isEven1.test(4));
        System.out.println("Is 7 even? " + isEven1.test(7));
    }
}
