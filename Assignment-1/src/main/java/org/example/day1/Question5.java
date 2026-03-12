package org.example.day1;

import java.util.Scanner;

public class Question5 {
    static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int fact=1;

        while(n>0){
            fact=fact*n;
            n--;
        }
        System.out.println(fact);
    }
}
