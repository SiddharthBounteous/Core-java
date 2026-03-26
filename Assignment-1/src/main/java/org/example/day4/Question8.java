package org.example.day4;

public class Question8 {
    int findNthFibonacci(int n){
        if(n<=1){
            return n;
        }
        return findNthFibonacci(n-1)+findNthFibonacci(n-2);
    }
    static void main(String[] args) {
        Question8 obj=new Question8();
        int ans=obj.findNthFibonacci(3);
        System.out.println(ans);
    }
}
