package org.example.day1;

import java.util.Scanner;

public class Question6 {
    static void main(String[] args) {
        String s="#Raj67dha89i";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the password");
        String ans=sc.next();
        do {
            if(ans.equals(s)){
//                System.out.println("Password are matching");
                break;
            }
            else{
                System.out.println("Enter the password Again!!!");
                ans=sc.next();
            }
        }while(!ans.equals(s));
        System.out.println("Password are matching");
    }
}
