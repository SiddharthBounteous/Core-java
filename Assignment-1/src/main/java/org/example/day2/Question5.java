package org.example.day2;
class Solution5{
    public int modifiedBinarySearch(int [] nums,int target,int left,int right){
        if(left>right){
            return -1;
        }

        int mid=left+(right-left)/2;

        if(nums[mid]==target){
            return mid;
        }

        //if left half is sorted
        if(nums[mid]>=nums[left]){

            //if key is the left half
            if(nums[left]<=target && target<=nums[mid]){
                return modifiedBinarySearch(nums,target,left,mid-1);
            }
            else{
                return modifiedBinarySearch(nums,target,mid+1,right);
            }
        }
        //if right half is sorted
        else{

            //if key is the right half
            if(nums[mid]<=target && target<=nums[right]){
                return modifiedBinarySearch(nums,target,mid+1,right);
            }
            else{
                return modifiedBinarySearch(nums,target,left,mid-1);
            }
        }
    }
    public int search(int[] nums, int target) {
        return modifiedBinarySearch(nums,target,0,nums.length-1);
    }
}
public class Question5 {
    static void main(String[] args) {
        int num[]={7,8,9,0,1,2,3,4,5,6};
        int target=8;

        Solution5 obj=new Solution5();
        int ans=obj.search(num,target);

        System.out.println(ans);
    }
}
