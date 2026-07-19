package Java8Features.MethodReferences;
@FunctionalInterface
interface MyInterface2
{
    void display();
}

class Demo
{
    static void showMessage()
    {
        System.out.println("Hello from static method!");
    }
}
public class Main3 {
    public static void main(String[] args) {
        //Reference to a Static Method
        //A static method reference lets us call a class’s static method directly, without writing extra code. It’s a shorter way to replace a lambda that only calls that method.
        // Way 1 : Using Lambda
        MyInterface2 obj1 = () -> Demo.showMessage();
        obj1.display();

        // Way 2 : Using Method Reference
        MyInterface2 obj2 = Demo::showMessage;
        obj2.display();
    }
}
