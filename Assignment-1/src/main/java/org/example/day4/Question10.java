package org.example.day4;

public class Question10 {
    public int binarySearch(int l,int r,int target,int arr[]){
        if(l>r){
            return -1;
        }
        int mid=l+(r-l)/2;

        if(target==arr[mid]){
            return mid;
        }

        else if(target>arr[mid]){
            return binarySearch(mid+1,r,target,arr);
        }
        else{
            return binarySearch(l,mid,target,arr);
        }
    }

    static void main(String[] args) {
        int [] nums={1,3,5,7,8,9};
        int n=nums.length;
        int target=8;

        Question10 obj=new Question10();
        int ans= obj.binarySearch(0,n-1,target,nums);
        System.out.println(ans);
    }
}
