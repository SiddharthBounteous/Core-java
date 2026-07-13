package OOPSConcept;

public interface Interface1 {

    default void m1(){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Interface1 obj=new Interface1() {
            @Override
            public void m1() {
                Interface1.super.m1();
            }
        };
    }
}
