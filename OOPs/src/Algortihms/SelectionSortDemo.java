package Algortihms;

public class SelectionSortDemo {
    public void selectionSort(int [] nums){

        int n=nums.length;

        for(int i=0;i<n-1;i++){
            int smallestIdx=i;  //unsorted part starting
            for(int j=i+1;j<n;j++){
                //compare smallestIdx with every j
                if(nums[j]<nums[smallestIdx]){
                    smallestIdx=j;
                }
            }
            int temp=nums[smallestIdx];
            nums[smallestIdx]=nums[i];
            nums[i]=temp;
        }
    }

    public static void main(String[] args) {
        SelectionSortDemo selectionSortDemo=new SelectionSortDemo();

        int [] nums={4,1,5,2,3};
        System.out.println("Before Sorting");

        for(int num:nums){
            System.out.print(num+" ");
        }
        System.out.println();
        selectionSortDemo.selectionSort(nums);

        System.out.println("After Sorting");

        for(int num:nums){
            System.out.print(num+" ");
        }
    }
}
