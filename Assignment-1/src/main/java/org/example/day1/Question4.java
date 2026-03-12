package org.example.day1;

import java.util.Scanner;

public class Question4 {
    static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        for(int i=1;i<=10;i++){
            System.out.println(n+" x "+i+" = "+n*i);
        }
    }
}
