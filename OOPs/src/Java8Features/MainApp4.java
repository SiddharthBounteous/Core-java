package Java8Features;

import java.util.function.Consumer;

public class MainApp4 {
    public static void main(String[] args)
    {
        // Consumer to print a message using anonymous class
        Consumer<String> printMessage = new Consumer<String>() {
            @Override
            public void accept(String msg) {
                System.out.println("Message: " + msg);
            }
        };
        Consumer<Integer> printInteger= val-> System.out.println(val);
        Consumer<Integer> printSqaure=val-> System.out.println(val*val);
        Consumer<String> printLength = msg -> System.out.println("Length: " + msg.length());


        // Test messages
        printMessage.accept("Hello Java");
        printMessage.andThen(printLength).accept("Welcome to Consumer Interface");
        printSqaure.andThen(printInteger).accept(5); //will accept same type of data

    }
}
