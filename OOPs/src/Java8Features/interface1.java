package Java8Features;

@FunctionalInterface
public interface interface1 {
    void greet(String name);
}

class Greet implements interface1
{
    @Override
    public void greet(String name)
    {
        System.out.println("Hello, " + name + "!");
    }
}

class MainApp6
{
    public static void main(String[] args)
    {
        Greet obj = new Greet();
        obj.greet("Siddharth");   // Calls the implemented method
    }
}
