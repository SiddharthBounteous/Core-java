package org.example.day4;
class Area{

    public void calculateArea(double radius){
        System.out.println(radius*radius*3.14);
    }

    public int calculateArea(int length,int width){
        return length*width;
    }

    public double calculateArea(double base,double height,boolean isTriangle){
        return (1.0/2.0)*base*height;
    }
}
public class Question1 {
    static void main(String[] args) {
        Area obj=new Area();
        obj.calculateArea(4);
        int ans=obj.calculateArea(6,8);
        double ans2=obj.calculateArea(8.9,9.8,true);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
