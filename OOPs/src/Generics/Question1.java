package Generics;

public class Question1 {
    static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.setValue("Hello");

        Box<Integer> box2 = new Box<>();
        box2.setValue(100);

        System.out.println(box1.getValue());  // Hello
        System.out.println(box2.getValue());  // 100
    }
}
