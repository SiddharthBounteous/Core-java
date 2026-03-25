package org.example.day2;

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    private void swap(int pos1,int pos2,int nums[]){
        int temp=nums[pos1];
        nums[pos1]=nums[pos2];
        nums[pos2]=temp;
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int start=0;
        int mid=0;
        int end=n-1;

        while(mid<=end){
            switch(nums[mid]){
                case 0:
                    swap(start,mid,nums);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(mid,end,nums);
                    end--;
                    break;
            }
        }

    }
}
public class Question1 {
    static void main(String[] args) {
        int nums[]={2,0,2,1,1,0};
        Solution1 obj=new Solution1();
        obj.sortColors(nums);
        for(int it:nums){
            System.out.print(it+" ");
        }
    }
}
