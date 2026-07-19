package Java8Features;

interface MyInterface
{
    // Abstract method (must be implemented by implementing classes)
    void m1();

    // Default method (has a body, optional to override)
    default void m2()
    {
        System.out.println("This is a default method inside an interface.");
    }
}

class MyClass implements MyInterface
{
    @Override
    public void m1()
    {
        System.out.println("Implementation of abstract method.");
    }
}

public class MainApp1
{
    public static void main(String[] args)
    {
        MyClass obj = new MyClass();
        obj.m1();   // Calls implemented abstract method
        obj.m2();   // Calls interface default
    }
}
