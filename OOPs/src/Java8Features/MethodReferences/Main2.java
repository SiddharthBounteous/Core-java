package Java8Features.MethodReferences;

@FunctionalInterface
interface MyInterface1
{
    void displayMsg(String msg);
}

public class Main2
{
    public static void main(String[] args)
    {
        //Reference to instance method of particular type
        //It means calling a method on any object of a class (not just one specific object). It is useful when we want to perform the same action on many objects, and it helps us write less code.
        // Way 1 : Using Lambda
        MyInterface1 obj1 = (msg) -> System.out.println(msg);
        obj1.displayMsg("Hello World!");

        // Way 2 : Using Method Reference
        MyInterface1 obj2 = System.out::println;
        obj2.displayMsg("Hello World!");
    }
}
