package Collections;

import java.util.*;

class Student implements Comparable<Student>{
    int id;
    String name;
    int marks;

    Student(int id, String name,int marks) {
        this.id = id;
        this.name = name;
        this.marks=marks;
    }

    @Override
    public int compareTo(Student other) {
        return this.id - other.id;
    }

    @Override
    public String toString() {
        return id + " " + name+" "+marks;
    }
}
public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(3, "Ram", 80));
        students.add(new Student(1, "Aman", 90));
        students.add(new Student(2, "Shyam", 70));

        Collections.sort(students);
        System.out.println("Sorted by id:");
        System.out.println(students);

        students.sort((s1, s2) -> s1.marks - s2.marks);
        System.out.println("Sorted by marks:");
        System.out.println(students);

        students.sort((s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println("Sorted by name:");
        System.out.println(students);

    }
}
