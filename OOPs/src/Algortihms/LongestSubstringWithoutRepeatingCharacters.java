package Algortihms;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        Map<Character,Integer>mp=new HashMap<>();

        int i=0,j=0;
        int maxLen=0;
        int len=0;

        while(j<n){
            char ch=s.charAt(j);

            if(mp.containsKey(ch)){
                if(mp.get(ch)>=i){
                    i=mp.get(ch)+1;
                }
            }
            len=j-i+1;
            maxLen=Math.max(maxLen,len);
            mp.put(ch,j);
            j++;
        }

        return maxLen;
    }
}
