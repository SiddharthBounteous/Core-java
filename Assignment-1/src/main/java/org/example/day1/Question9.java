package org.example.day1;

import java.util.Scanner;

public class Question9 {
    static void main(String[] args) {
        System.out.println("Enter a number to check");
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int d=n;
        int temp=0;

        while(d>0){
            int num=d%10;
            temp=temp*10+num;
            d=d/10;
        }

        if(temp==n){
            System.out.println("Palindrome is there");
        }
        else{
            System.out.println("Not a Palindrome");
        }
    }
}
