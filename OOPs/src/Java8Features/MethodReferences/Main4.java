package Java8Features.MethodReferences;

@FunctionalInterface
interface MyInterface3
{
    Greeting1 getGreeting();
}

class Greeting1
{
    Greeting1()
    {
        System.out.println("Greeting object created!");
    }
}
public class Main4 {
    public static void main(String[] args) {
        //Reference to a Constructor
        //A constructor reference lets us create a new object quickly without extra code. It’s a shortcut for calling a class’s new method.
        // Way 1 : Using Lambda
        MyInterface3 obj1 = () -> new Greeting1();
        obj1.getGreeting();

        // Way 2 : Using Constructor Reference
        MyInterface3 obj2 = Greeting1::new;
        obj2.getGreeting();
    }
}
