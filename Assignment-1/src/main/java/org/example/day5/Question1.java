package org.example.day5;
class Car{
    private String make;
    private String model;
    private int year;
    private double currentSpeed;

    public void accelerateSpeed(double speedIncrease){
        currentSpeed+=speedIncrease;

        System.out.println("Current Speed "+currentSpeed);
    }

    public void brake(double decreaseSpeed){
        currentSpeed-=decreaseSpeed;

        if(currentSpeed<0){
            currentSpeed=0.0;
        }

        System.out.println("Current Speed "+currentSpeed);
    }
}
public class Question1 {
    public static void main(String[] args) {
        Car obj1=new Car();
        Car obj2=new Car();
        obj1.accelerateSpeed(50);
        obj1.brake(20);
        obj2.accelerateSpeed(100);
        obj2.brake(30);

    }
}
