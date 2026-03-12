package org.example.day1;

import java.util.Scanner;

public class Question2 {
    static void main(String[] args) {
        System.out.println("Enter the percentage");
        Scanner sc=new Scanner(System.in);
        int percentage=sc.nextInt();

        if(percentage<0 || percentage>100){
            System.out.println("Error: Invalid percentage entered.\n");
        }
        else if(percentage>=90){
            System.out.println("Grade: A\n");
        }
        else if(percentage>=80){
            System.out.println("Grade: B\n");
        }
        else if(percentage>=70){
            System.out.println("Grade: C\n");
        }
        else if(percentage>=60){
            System.out.println("Grade: D\n");
        }
        else{
            System.out.println("Grade: F\n");
        }
    }
}
