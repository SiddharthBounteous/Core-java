package importantConcepts;

import java.util.Objects;

public class Student {
    private int id;
    private String name;

    public Student(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;  //same reference
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return this.id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static void main(String[] args) {
        Student s1=new Student(1,"Siddharth");
        Student s2=new Student(1,"Rohan");

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }
}
