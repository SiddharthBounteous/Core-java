package OOPSConcept;

interface Marker { }

// Class implementing Marker
class MyClass implements Marker
{
    public void display()
    {
        System.out.println("Display method called");
    }
}

public class MainApp
{
    public static void main(String[] args)
    {
        MyClass obj = new MyClass();

        if (obj instanceof Marker) {
            obj.display();
        } else {
            System.out.println("Object not allowed");
        }
    }
}