package Generics;

public class Question3 {
    static void main(String[] args) {
        Stack<String> stringStack=new Stack<>();
        stringStack.push("Java");
        stringStack.push("Generics");

        System.out.println("Top item: " + stringStack.peek());
        System.out.println("Popped: " + stringStack.pop());
        System.out.println("Top item: " + stringStack.peek());
        System.out.println("Is empty? " + stringStack.isEmpty());
    }
}
