package Generics;

import java.util.*;

public class Question4 {

    // Generic copy method
    public static <T> void copy(List<? extends T> source,List<? super T> destination) {

        System.out.println("---- Copy Method Called ----");
        System.out.println("Source type: " + source.get(0).getClass().getSimpleName());

        for (T item : source) {
            destination.add(item);
        }
    }

    public static void main(String[] args) {

        // Example 1
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Number> numberList = new ArrayList<>();

        copy(intList, numberList);
        System.out.println("After copying intList to numberList:");
        System.out.println(numberList);
        System.out.println();


        // Example 2
        List<Number> numSource = Arrays.asList(10, 20.5);
        List<Object> objList = new ArrayList<>();

        copy(numSource, objList);
        System.out.println("After copying numSource to objList:");
        System.out.println(objList);
        System.out.println();


        // Example 3
        List<Integer> intSource = Arrays.asList(100, 200);
        List<Object> objList2 = new ArrayList<>();

        copy(intSource, objList2);
        System.out.println("After copying intSource to objList2:");
        System.out.println(objList2);
    }
}