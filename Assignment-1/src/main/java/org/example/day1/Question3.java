package org.example.day1;

import java.util.Scanner;

public class Question3 {
    static void main(String[] args) {
        System.out.println("Enter a character to check");

        Scanner sc=new Scanner(System.in);

        String ch=sc.next();
        if(ch.length()>1){
            System.out.println("Pls enter single character");
            return;
        }
        String con=ch.toLowerCase();
        char c=con.charAt(0);

        switch (c){
            case 'a':
                System.out.println("It is a Vowel");
                break;
            case 'e':
                System.out.println("It is a Vowel");
                break;
            case 'i':
                System.out.println("It is a Vowel");
                break;
            case 'o':
                System.out.println("It is a Vowel");
                break;
            case 'u':
                System.out.println("It is a Vowel");
                break;
            default:
                System.out.println("It is a not Vowel");
        }
    }
}
