package org.example.day5;

class Employee{
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee(int id,String name){
        this(id,name,"Unassigned",0.0);
    }

    public Employee(int id,String name,String department){
        this(id,name,department,0.0);
    }

    void display(){
        System.out.println(id+" "+name+" "+department+" "+salary);
    }
}
public class Question5 {
    static void main(String[] args) {
        Employee e1=new Employee(1,"Siddharth","IT",50000);
        Employee e2=new Employee(2,"Rahul");
        Employee e3=new Employee(3,"Mohan","HR");

        e1.display();
        e2.display();
        e3.display();
    }
}
