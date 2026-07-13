package Collections;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();

        list1.add(10);
        list1.add(20);
        list1.add(30);

        ArrayList<Integer> list2 = (ArrayList<Integer>) list1.clone();

        System.out.println(list1);
        System.out.println(list2);

        System.out.println(list1 == list2);

        list2.add(40);

        System.out.println(list1);
        System.out.println(list2);
    }
}
