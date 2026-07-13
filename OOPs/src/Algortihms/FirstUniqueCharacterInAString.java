package Algortihms;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int [] freq=new int[26];

        int n=s.length();

        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(freq[ch-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
