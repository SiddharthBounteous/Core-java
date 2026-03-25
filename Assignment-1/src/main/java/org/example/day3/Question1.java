package org.example.day3;
class Solution1{
    public boolean isAnagram(String s, String t) {
        int arr[]=new int[26];

        int n=s.length();
        int m=t.length();

        if(n!=m){
            return false;
        }

        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
        }

        for(int i=0;i<m;i++){
            arr[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
public class Question1 {
    static void main(String[] args) {
        Solution1 obj=new Solution1();

        boolean ans=obj.isAnagram("listen","silent");
        System.out.println(ans);
    }
}
