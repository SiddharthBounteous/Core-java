package Java8Features;

@FunctionalInterface
interface MyInterface2
{
    void greet(String name);

    //you can still have default and static methods
    default void m2()
    {
        System.out.println("Default method inside functional interface");
    }
}
public class MainApp7 {
    public static void main(String[] args) {
        MyInterface2 myInterface2=new MyInterface2() {
            @Override
            public void greet(String name) {
                System.out.println("Hello "+name+" !");
            }
        };

        MyInterface2 myInterface3=(String name)->{
            System.out.println("Siddharth"+name);
        };
        myInterface3.greet(" love me");

        myInterface2.greet("World");
        myInterface2.m2();

        /*
        In this program, the Java compiler internally creates an anonymous class similar to:
        class MainApp7$1 implements MyInterface2
        {
            @Override
            public void greet(String name)
            {
                System.out.println("Hello " + name + " !");
            }
        }
        */
    }
}
