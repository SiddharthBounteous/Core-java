package org.example.day3;

class Solution7{
    public boolean validate(String password){
        String regex="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";

        if(password.matches(regex)){
            return true;
        }
        return false;
    }
}
public class Question7 {
    static void main(String[] args) {
        Solution7 obj=new Solution7();
        boolean ans=obj.validate("@Code123");
        boolean ans1=obj.validate("Code123");
        System.out.println(ans);
        System.out.println(ans1);
    }
}
