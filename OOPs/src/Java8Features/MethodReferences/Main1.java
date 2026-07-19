package Java8Features.MethodReferences;

@FunctionalInterface
interface MyInterface
{
    void greet();
}

class Greeting
{
    void sayHello()
    {
        System.out.println("Hello from instance method!");
    }
    void sayBye(){
        System.out.println("Bye from instance method");
    }
    void display(String name){
        System.out.println("name: "+name);
    }
}
public class Main1 {
    public static void main(String[] args) {
        //reference to instance method
        //This type lets us use a method from an object we already have. Instead of writing a new function, we can directly refer to that object’s method.
        Greeting g = new Greeting();

        // Way 1 : Using Lambda
        //You are assigning an implementation of the functional interface that points to that method.
        MyInterface obj1 = () -> g.sayHello();
        obj1.greet();

        // Way 2 : Using Method Reference
        MyInterface obj2 = g::sayHello;  //Whenever someone calls greet(), forward that call to g.sayHello()
        obj2.greet();

        MyInterface obj3=g::sayBye;
        obj3.greet();
//        MyInterface obj4=g::display;  //error
        //The method reference must match the functional interface method signature.
    }
}
