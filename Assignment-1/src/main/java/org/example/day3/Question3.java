package org.example.day3;

class Solution3{

    public int solve(String s,int i,int j,int [][]dp){
        if(i>=j){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=solve(s,i+1,j-1,dp);
        }
        return dp[i][j]=0;
    }
    public String longestPalindrome(String s) {
//        int n=s.length();
//        int maxLen=Integer.MIN_VALUE;
//        int [][] dp=new int[n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                dp[i][j]=-1;
//            }
//        }
//        int sp=0;
//        int ep=0;
//        for(int i=0;i<n;i++){
//            for(int j=i;j<n;j++){
//                if(solve(s,i,j,dp)==1){
//                    if(j-i+1>maxLen){
//                        maxLen=j-i+1;
//                        sp=i;
//                        ep=j+1;
//                    }
//                }
//            }
//        }
//
//        return s.substring(sp,ep);
        int n=s.length();

        if(n<2){
            return s;
        }

        int start=0;
        int end=0;
        int maxLen=1;

        for(int i=0;i<n;i++){
            //for even
            int l=i-1;
            int r=i;

            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLen){
                    maxLen=r-l+1;
                    start=l;
                    end=r;
                }
                l--;
                r++;
            }
            //for odd
            l=i-1;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLen){
                    maxLen=r-l+1;
                    start=l;
                    end=r;
                }
                l--;
                r++;
            }
        }
        return s.substring(start,end+1);
    }
}
public class Question3 {
    static void main(String[] args) {
        Solution3 obj=new Solution3();
        String ans=obj.longestPalindrome("babad");
        System.out.println(ans);
    }
}
