package org.example.day2;
class Solution7{
    public int maxSubarraySumOfSizeK(int[] nums,int k){
        int n=nums.length;

        int i=0,j=0;
        int maxi=Integer.MIN_VALUE;

        int total=0;

        while(i<n && j<n){
            total+=nums[j];
            int s=j-i+1;
            if(s<k){
                j++;
                continue;
            }
            if(s==k){
                maxi=Math.max(total,maxi);
                total-=nums[i];
                i++;
                j++;
            }
        }
        return maxi;
    }
}
public class Question7 {
    static void main(String[] args) {
        int arr[]={1,9,1,3,13,7};
        int k=3;

        Solution7 obj=new Solution7();

        int ans=obj.maxSubarraySumOfSizeK(arr,k);
        System.out.println(ans);
    }
}
