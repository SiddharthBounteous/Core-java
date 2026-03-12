package org.example.day1;

import java.util.Scanner;

public class Question8 {
    static void main(String[] args) {
        System.out.println("Enter a number to check");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                System.out.println("Not a Prime Number");
                return;
            }
        }

        System.out.println("Prime Number");
    }
}
