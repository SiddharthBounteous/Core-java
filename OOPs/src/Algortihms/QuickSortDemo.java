package Algortihms;

class Solution1{
    public void quickSort(int [] arr,int low, int high){
        if(low>=high){
            return;
        }

        int Pi=partition(arr,low,high);

        quickSort(arr,low,Pi-1);
        quickSort(arr,Pi+1,high);
    }

    public int partition(int [] arr,int low,int high){
        int pivot=arr[high];  //we are taking it as high index

        int pi=low;
        for(int i=low;i<high;i++){
            if(arr[i]<=pivot){
                int temp=arr[pi];
                arr[pi]=arr[i];
                arr[i]=temp;
                pi++;
            }
        }
        int temp=arr[high];
        arr[high]=arr[pi];
        arr[pi]=temp;
        return pi;
    }
}
public class QuickSortDemo {
    public static void main(String[] args) {
        int [] arr={4,5,3,1,0,9,5};

        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println("\n----After Sorting------");

        Solution1 obj=new Solution1();
        obj.quickSort(arr,0,arr.length-1);

        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}
