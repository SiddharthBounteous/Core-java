package org.example.day3;
//-9812abc
class Solution10{
    public int myAtoi(String s) {
        s=s.trim();  //remove leading spaces

        if(s.isEmpty()){
            return 0;
        }
        int sign=1;
        int i=0;

        if(s.charAt(i)=='+' || s.charAt(i)=='-'){
            sign=(s.charAt(i)=='-')?-1:1;
            i++;
        }
        int n=s.length();
        long num=0;

        while(i<n && Character.isDigit(s.charAt(i))){
            num=num*10+(s.charAt(i)-'0');
            if(num*sign>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(num*sign<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sign*num);
    }
}
public class Question10 {
    static void main(String[] args) {
        Solution10 obj=new Solution10();

        int ans=obj.myAtoi("1337c0d3");
        System.out.println(ans);
    }
}
