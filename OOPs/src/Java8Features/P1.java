package Java8Features;

@FunctionalInterface
interface FunctionalInterface1 {
    void canFly(String fly);
}

public class P1{
    public static void main(String[] args) {
        FunctionalInterface1 obj=(String value)->{
            System.out.println("Eagle Bird");
        };
        obj.canFly("vertical");
    }
}


