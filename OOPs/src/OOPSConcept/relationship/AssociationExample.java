package OOPSConcept.relationship;

class Address
{
    String city = "Delhi";
    String country = "India";

    void displayAddress()
    {
        System.out.println("City: " + city + ", Country: " + country);
    }
}

class Student
{
    String name = "Deepak";
    int rollno = 101;

    // Direct reference to another class
    Address address = new Address();  // Object created directly inside the class

    void displayInfo()
    {
        System.out.println("Name: " + name + ", Roll No: " + rollno);
        address.displayAddress();
    }
}
class ByConstructorInjection{
    private Address address;

    ByConstructorInjection(Address address){
        this.address=address;
    }

    void displayByConstructor(){
        address.displayAddress();
    }
}
class Processor
{
    void startProcessor()
    {
        System.out.println("Processor starts processing.");
    }
}

class Laptop
{
    // HAS-A relationship: Laptop has a Processor
    private Processor processor;

    // Setter Injection: Injecting dependency through setter method
    public void setProcessor(Processor processor)
    {
        this.processor = processor;
    }

    void startLaptop()
    {
        processor.startProcessor();
        System.out.println("Laptop starts.");
    }
}
public class AssociationExample
{
    public static void main(String[] args)
    {
        Student student = new Student();  // No need to pass Address
        student.displayInfo();            // Displays student info along with address
        Address address=new Address();

        //inject the dependency
        ByConstructorInjection byConstructorInjection=new ByConstructorInjection(address);
        byConstructorInjection.displayByConstructor();

        // Create the dependency
        Processor processor = new Processor();

        // Create the dependent object
        Laptop myLaptop = new Laptop();

        // Inject the dependency using setter
        myLaptop.setProcessor(processor);

        // Use the dependent object
        myLaptop.startLaptop();
    }
}
