package org.example.day5;
class BankAccount{
    private double amount;

    public BankAccount(double amount){
        this.amount=amount;
    }

    public double getBalance(){
        return amount;
    }

    public void deposit(double amt){
        if(amt>0){
            this.amount+=amt;
            System.out.println("Amount Deposited "+amt);
        }
        else{
            System.out.println("Amount can't be negative or zero");
        }
    }

    public void withdraw(double amt){
        if(amt>this.amount){
            System.out.println("Withdrawn amount cannot be greater than current balance");
        }
        else{
            this.amount-=amt;
            System.out.println("Amount Withdrawn "+amt);
        }

    }
}
public class Question9 {
    static void main(String[] args) {
        BankAccount ba=new BankAccount(1000.0);

        ba.withdraw(500.0);
        double ans=ba.getBalance();
        System.out.println(ans);
        ba.deposit(800.0);
        double ans1=ba.getBalance();
        System.out.println(ans1);
    }
}
