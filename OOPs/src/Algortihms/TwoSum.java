package Algortihms;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;

        HashMap<Integer,Integer>mp=new HashMap<>();
        int [] result=new int[2];
        int j=0;

        while(j<n){
            if(mp.containsKey(target-nums[j])){
                result[0]=mp.get(target-nums[j]);
                result[1]=j;
                break;
            }
            mp.put(nums[j],j);
            j++;
        }

        return result;
    }
}
