package org.example.day5;
class Box{
    double width;
    double height;
    double depth;


}
public class Question2 {
    static void main(String[] args) {
        Box b1=new Box();
        b1.depth=10.0;
        b1.height=10.0;
        b1.width=10.0;

        Box b2=b1;

        b2.width=50.0;

        System.out.println(b1.width);
    }
}
