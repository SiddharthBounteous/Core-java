package org.example.day2;
class Solution{
    public int maxSubarray(int [] nums){
        int n=nums.length;

        int max_so_far=nums[0];
        int curr_max=nums[0];

        for(int i=1;i<n;i++){
            curr_max=Math.max(nums[i],nums[i]+curr_max);
            max_so_far=Math.max(max_so_far,curr_max);
        }

        return max_so_far;
    }
}
public class Question2 {
    static void main(String[] args) {
        int nums[]={-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution obj=new Solution();
        int result=obj.maxSubarray(nums);
        System.out.println(result);
    }
}
