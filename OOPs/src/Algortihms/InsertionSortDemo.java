package Algortihms;

public class InsertionSortDemo {
    public void insertionSort(int [] nums){
        int n=nums.length;

        for(int i=1;i<n;i++){
            int curr=nums[i];  //first element in unsorted part
            int prev=i-1;

            while(prev>=0 && nums[prev]>curr){
                nums[prev+1]=nums[prev];
                prev--;
            }

            nums[prev+1]=curr;  //at last, we put it to correct position in sorted part
        }
    }

    public static void main(String[] args) {
        InsertionSortDemo insertionSortDemo=new InsertionSortDemo();

        int [] nums={4,1,5,2,3};
        System.out.println("Before Sorting");

        for(int num:nums){
            System.out.print(num+" ");
        }
        System.out.println();
        insertionSortDemo.insertionSort(nums);

        System.out.println("After Sorting");

        for(int num:nums){
            System.out.print(num+" ");
        }
    }
}
