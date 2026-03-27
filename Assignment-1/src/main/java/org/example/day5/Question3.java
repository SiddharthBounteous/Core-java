package org.example.day5;
class Rectangle{
    int length;
    int width;

    public Rectangle(){
        this.length=1;
        this.width=1;
    }

    public Rectangle(int size){
        this.length=size;
        this.width=size;
    }

    public Rectangle(int length,int width){
        this.length=length;
        this.width=width;
    }

    public void print(){
        System.out.println(length+" "+width);
    }
}
public class Question3 {
    static void main(String[] args) {
        Rectangle obj1=new Rectangle();
        Rectangle obj2=new Rectangle(4);
        Rectangle obj3=new Rectangle(5,3);
        obj1.print();
        obj2.print();
        obj3.print();
    }
}
