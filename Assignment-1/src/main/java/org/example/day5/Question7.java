package org.example.day5;
class Student{
    private int studentId;
    private String name;
    private double gpa;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
public class Question7 {
    static void main(String[] args) {
        Student s1=new Student();
        s1.setName("Siddharth");
        s1.setStudentId(1);
        s1.setGpa(9.5);

        String name=s1.getName();
        int id=s1.getStudentId();
        double gpa=s1.getGpa();
        System.out.println(name+" "+id+" "+gpa);
    }
}
