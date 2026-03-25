package org.example.day3;

import java.util.HashSet;
import java.util.Set;

class Solution2{
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st=new HashSet<>();

        int maxLen=0;
        int i=0;

        int n=s.length();

        for(int j=0;j<n;j++){

            while(st.contains(s.charAt(j))){
                st.remove(s.charAt(i));
                i++;
            }

            st.add(s.charAt(j));
            maxLen=Math.max(maxLen,j-i+1);
        }

        return maxLen;
    }
}
public class Question2 {
    static void main(String[] args) {
        Solution2 obj=new Solution2();
        int ans=obj.lengthOfLongestSubstring("abcabcbcb");
        System.out.println(ans);
    }
}
