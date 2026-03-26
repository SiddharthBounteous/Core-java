package org.example.day4;
class Solution4{
    public void countUp(int n){
        if(n==0){
            return;
        }
        countUp(n-1);
        System.out.print(n+" ");  //delayed execution
    }
    public void countDown(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");  //immediate execution
        countDown(n-1);
    }
}
public class Question4 {
    static void main(String[] args) {
        Solution4 obj=new Solution4();
        int n = 5;

        System.out.print("Count Down: ");
        obj.countDown(n);

        System.out.println();

        System.out.print("Count Up: ");
        obj.countUp(n);
    }
}
