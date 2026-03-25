package org.example.day3;
class Solution4{
    public String compress(String s) {

        StringBuilder str=new StringBuilder();
        int n=s.length();
        int count=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i-1)==s.charAt(i)){
                count++;
            }
            else{
                str.append(s.charAt(i-1));
                str.append(count);
                count=1;
            }
        }
        str.append(s.charAt(n-1));
        str.append(count);
        if(str.length()>=s.length()){
            return s;
        }
        return str.toString();
    }
}
public class Question4 {
    static void main(String[] args) {
        Solution4 obj=new Solution4();
        String ans=obj.compress("aabcccccaaa");
        System.out.println(ans);
    }
}
