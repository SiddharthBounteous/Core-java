package Collections;

public class Exception1 {
    public static void main(String[] args) {
        int a=10;
        int b=0;
        int c=0;

        try{
            c=a/b;
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }

        System.out.println(c);
    }
}
