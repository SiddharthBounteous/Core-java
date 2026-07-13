package Algortihms;

public class KadaneAlgo {

    public int maxSubArray(int[] nums) {
        //brute force
        int maxSum=Integer.MIN_VALUE;

        int n=nums.length;
        int currsum=0;

//        for(int i=0;i<n;i++){
//            currsum=0;
//            for(int j=i;j<n;j++){
//                currsum+=nums[j];
//                maxSum=Math.max(maxSum,currsum);
//            }
//        }

        for(int i=0;i<n;i++){
            currsum+=nums[i];
            maxSum=Math.max(currsum,maxSum);
            if(currsum<0){
                currsum=0;
            }
        }

        return maxSum;
    }
}
