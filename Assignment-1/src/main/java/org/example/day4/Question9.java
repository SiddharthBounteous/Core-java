package org.example.day4;

public class Question9 {
    public int findPower(int x,int n){

        if(n==0){
            return 1;  //x^0=1
        }

        int half=findPower(x,n/2);
        int result=half*half;

        if(n%2==1){
            result=result*x;
        }
        return result;
    }
    static void main() {
        Question9 obj=new Question9();
        int ans= obj.findPower(2,10);
        System.out.println(ans);
    }
}
