package org.example.day5;
class Student1{
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
        if(gpa<0.0 || gpa>4.0){
            System.out.println("GPA can't be less than 0.0 or greater than 4.0");
        }
        else{
            this.gpa = gpa;
        }
    }
}
public class Question8 {
    static void main(String[] args) {
        Student1 obj=new Student1();

        obj.setName("Siddharth");
        obj.setGpa(9.5);
        obj.setStudentId(1);

        String name=obj.getName();
        int id=obj.getStudentId();
        double gpa=obj.getGpa();
        System.out.println(name+" "+id+" "+gpa);
    }
}
