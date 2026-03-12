package org.example.day1;

import java.util.Scanner;

public class Question7 {
    static void main(String[] args) {
        System.out.println("Enter the numbers you want");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=0;
        int b=1;
        if(n>=1){
            System.out.println(a);
        }
        if(n>=2){
            System.out.println(b);
        }

        for(int i=3;i<=n;i++){
            int c=a+b;
            System.out.println(c);
            a=b;
            b=c;

        }

    }
}
