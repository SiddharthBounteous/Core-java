package org.example.day5;
class Person{
    String name;
    int age;
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
//    public Person(String name,int age){
//        name=name;
//        age=age;
//    }

    void display(){
        System.out.println(name + " " + age);
    }
}
public class Question4 {
    static void main(String[] args) {
        Person p=new Person("Aditya",25);
        p.display();
    }
}
