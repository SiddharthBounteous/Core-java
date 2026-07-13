package Algortihms;
class Solution{
    public void merge(int [] arr,int l,int m,int r){
        int n1=m-l+1;  //for left side array
        int n2=r-m;   //for right side array;

        int [] Left=new int[n1];
        int [] Right=new int[n2];

        int k=l;

        //fill Left
        for(int i=0;i<n1;i++){
            Left[i]=arr[k];
            k++;
        }
        //fill Right
        for(int i=0;i<n2;i++){
            Right[i]=arr[k];
            k++;
        }

        //Merge them in arr
        int i=0,j=0;
        k=l;

        while(i<n1 && j<n2){
            if(Left[i]<=Right[j]){
                arr[k]=Left[i];
                i++;
            }
            else{
                arr[k]=Right[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k]=Left[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=Right[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int [] arr,int l,int r){

        if(l>=r){
            return;   //single element or invalid case
        }

        int mid=l+(r-l)/2;

        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);

        merge(arr,l,mid,r);
    }
}
public class MergeSortDemo {
    public static void main(String[] args) {
        int [] arr={4,5,3,1,0,9,5};

        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println("\n----After Sorting------");

        Solution obj=new Solution();
        obj.mergeSort(arr,0,arr.length-1);

        for(int num:arr){
            System.out.print(num+" ");
        }

    }
}
