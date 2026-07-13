package Collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employee1 {
    int id;
    String name;

    Employee1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " " + name;
    }
}
public class ComparatorDemo {
    public static void main(String[] args) {
        List<Employee1> employees = Arrays.asList(
                new Employee1(3, "Ram"),
                new Employee1(1, "Aman"),
                new Employee1(2, "Shyam"),
                new Employee1(3,"Arun")
        );

        Comparator<Employee1> byId=(e1,e2)->e1.id-e2.id;

        employees.sort(byId);
        System.out.println(employees);
        employees.sort(byId.reversed());
        System.out.println(employees);

        employees.sort(byId.thenComparing(e1->e1.name));
        System.out.println(employees);
    }
}
