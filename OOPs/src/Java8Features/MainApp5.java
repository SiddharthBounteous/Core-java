package Java8Features;

import java.util.function.Supplier;

public class MainApp5 {
    public static void main(String[] args)
    {
        // Supplier to provide a random number using anonymous class
        Supplier<Double> randomNumber = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };

        Supplier<String> supplier = () -> "Java 8";

        // Get numbers
        System.out.println("Random Number 1 : " + randomNumber.get());
        System.out.println("Random Number 2 : " + randomNumber.get());
        System.out.println(supplier.get());
    }
}
