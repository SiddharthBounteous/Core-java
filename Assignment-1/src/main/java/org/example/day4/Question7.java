package org.example.day4;

class Solution7{
    public boolean isPalindrome(String str,int l,int r){

        if(l>=r){
            return true;
        }

        if(str.charAt(l)!=str.charAt(r)){
            return false;
        }

        return isPalindrome(str,l+1,r-1);
    }
}
public class Question7 {
    static void main(String[] args) {
        Solution7 obj=new Solution7();
        String s="ababcbaba";

        int n=s.length();

        boolean ans=obj.isPalindrome(s,0,n-1);
        System.out.println(ans);
    }
}
