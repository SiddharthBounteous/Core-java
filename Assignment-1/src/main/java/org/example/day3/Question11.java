package org.example.day3;

import java.util.HashMap;
import java.util.Map;

class Solution11{
    public int romanToInt(String s) {
        Map<Character,Integer> mp=new HashMap<>();

        mp.put('I',1);
        mp.put('V',5);
        mp.put('C',100);
        mp.put('M',1000);
        mp.put('X',10);
        mp.put('D',500);
        mp.put('L',50);

        int result=mp.get(s.charAt(s.length()-1));

        for(int i=s.length()-2;i>=0;i--){
            if(mp.get(s.charAt(i))<mp.get(s.charAt(i+1))){
                result-=mp.get(s.charAt(i));
            }
            else{
                result+=mp.get(s.charAt(i));
            }
        }
        return result;
    }
}
public class Question11 {
    static void main(String[] args) {
        Solution11 obj=new Solution11();

        int ans=obj.romanToInt("MCMXCIV");
        System.out.println(ans);
    }
}
