package org.example.day1;

import java.util.Scanner;

public class Question12 {
    static void main(String[] args) {
        System.out.println("Welcome to ATM Project");
        Scanner sc=new Scanner(System.in);
        int balance=1000;

        while(true){
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice= sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Current Balance: Rs " + balance);
                    break;
                case 2:
                    System.out.println("Enter the amount for deposit");
                    int dep=sc.nextInt();
                    balance+=dep;
                    System.out.println("Amount deposited, Rs "+dep);
                    break;
                case 3:
                    System.out.println("Enter the amount to withdraw");
                    int wid=sc.nextInt();
                    if(wid>balance){
                        System.out.println("Amount withdrawn is greater than balance");
                    }
                    else{
                        balance-=wid;
                        System.out.println("Amount Withdrawn, Rs "+wid);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
