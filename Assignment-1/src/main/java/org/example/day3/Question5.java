package org.example.day3;

class Solution5{
    public String reverseWords(String s) {
        int n=s.length();

        StringBuilder ans=new StringBuilder();
        StringBuilder str=new StringBuilder(s);

        str.reverse();

        for(int i=0;i<n;i++){
            StringBuilder word=new StringBuilder();

            while(i<n && str.charAt(i)!=' '){
                word.append(str.charAt(i));
                i++;
            }

            word.reverse();

            if(!word.isEmpty()){
                ans.append(" ");
                ans.append(word);
            }
        }

        return ans.toString().substring(1);
    }
}
public class Question5 {
    static void main(String[] args) {
        Solution5 obj=new Solution5();
        String ans=obj.reverseWords(" a good   example  ");
        System.out.println(ans);
    }
}
