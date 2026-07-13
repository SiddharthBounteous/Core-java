package Collections;

import javax.lang.model.element.Name;

class Address1{
    String city;

    public Address1(String city){
        this.city=city;
    }

    // This creates a new Address object with the same city value.
    public Address1(Address1 address1){
        this.city=address1.city;
    }
}
class Person1{
    private String name;
    private Address1 address1;

    public Person1(String name,Address1 address1) {
        this.name = name;
        this.address1 = address1;
    }

    //here we are creating a new person object
    public Person1(Person1 originalPerson){
        this.name = originalPerson.name;

        // Creating a completely new Address object
        this.address1=new Address1(originalPerson.address1);
    }

    public void printDetails() {
        System.out.println(name + " lives in " + address1.city);
    }

    public Address1 getAddress() {
        return address1;
    }
}
public class DeepCopyDemo {
    public static void main(String[] args) {
        Address1 address1=new Address1("Kanpur");
        Person1 person1=new Person1("Siddharth",address1);

        person1.printDetails();

        // This creates:
        // 1. New Person object
        // 2. New Address object
        Person1 person2=new Person1(person1);
        person2.printDetails();

        System.out.println("------------------");

        person2.getAddress().city="Lucknow";
        person1.printDetails();
        person2.printDetails();

    }
}
