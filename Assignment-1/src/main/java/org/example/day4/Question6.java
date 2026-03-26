package org.example.day4;
class Solution6{
    public int addDigits(int num){
        if(num<10){
            return num;
        }

        return (num%10)+addDigits(num/10);
    }
}
public class Question6 {
    static void main(String[] args) {
        Solution6 obj=new Solution6();

        int ans=obj.addDigits(534);
        System.out.println(ans);
    }
}
