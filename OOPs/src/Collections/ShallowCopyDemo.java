package Collections;
class Address{
    String city;

    public Address(String city){
        this.city=city;
    }
}
class Person{
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Person(Person originalPerson){
        this.name=originalPerson.name;

        // This is shallow copy
        // We are copying only the reference of Address object.
        this.address=originalPerson.address;
    }

    public void printDetails() {
        System.out.println(name + " lives in " + address.city);
    }

    public Address getAddress() {
        return address;
    }
}
public class ShallowCopyDemo {
    public static void main(String[] args) {
        Address address=new Address("Kanpur");
        Person mother=new Person("Reenu",address);

        mother.printDetails();

        Person son=new Person(mother);

        son.printDetails();

        System.out.println("-----------");

        //Since address object is shared, this change will also be visible through son.
        mother.getAddress().city="Lucknow";

        son.printDetails();
        mother.printDetails();

        System.out.println("-----------");

        //Since address object is shared, this change will also be visible through mother.
        son.getAddress().city="Dehradun";

        son.printDetails();
        mother.printDetails();

    }
}
