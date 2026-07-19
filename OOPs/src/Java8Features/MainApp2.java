package Java8Features;

interface MyInterface1
{
// Abstract method (must be implemented by implementing classes)
void m1();

// Static method (can be called using interface name)
static void m2()
{
    System.out.println("This is a static method inside an interface.");
}
}

class MyClass1 implements MyInterface
{
    @Override
    public void m1()
    {
        System.out.println("Implementation of abstract method.");
    }
}

public class MainApp2
{
    public static void main(String[] args)
    {
        MyClass1 obj = new MyClass1();
        obj.m1();      // Calls implemented abstract method

        MyInterface1.m2();   // Calling static method using interface name
    }
}
