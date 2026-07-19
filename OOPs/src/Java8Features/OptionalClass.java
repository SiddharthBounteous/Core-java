package Java8Features;

import java.util.Optional;

public class OptionalClass {
    private static String getValue() {
        return null;
    }
    public static void main(String[] args) {
        // Creating an empty Optional
        Optional<String> emptyOpt = Optional.empty();

// Creating an Optional with a non-null value
        Optional<String> valueOpt = Optional.of("Java 8");

// Creating an Optional that may contain null
        Optional<String> nullableOpt = Optional.ofNullable(getValue());

        Optional<String> nameOpt = Optional.of("Deepak");

        // Checking if value is present
        if(nameOpt.isPresent()) {
            System.out.println("Value is present: " + nameOpt.get());
            System.out.println(nameOpt);
        }

        // Using ifPresent()
        nameOpt.ifPresent(name -> System.out.println("Hello, " + name));

        // Optional with null value
        Optional<String> emptyOpt1 = Optional.ofNullable(null);

        // Using orElse()
        String defaultName = emptyOpt1.orElse("Default Name");
        System.out.println("Value: " + defaultName);

        // Using map() and filter()
        Optional<String> result = nameOpt
                .filter(name -> name.startsWith("D"))
                .map(name -> name.toUpperCase());

        result.ifPresent(System.out::println);
    }
}
