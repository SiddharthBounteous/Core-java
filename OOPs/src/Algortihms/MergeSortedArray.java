package Algortihms;

public class MergeSortedArray {
    int [] solve(int [] nums1,int [] nums2){
        int m= nums1.length;
        int n=nums2.length;
        int[] result =new int[m+n];
        int i=0,j=0;
        int k=0;

        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                result[k]=nums1[i];
                i++;
                k++;
            }
            else{
                result[k]=nums2[j];
                j++;
                k++;
            }
        }

        while(i<m){
            result[k]=nums1[i];
            k++;
            i++;
        }

        while(j<n){
            result[k]=nums2[j];
            k++;
            j++;
        }

        return result;
    }
    public static void main(String[] args) {
        MergeSortDemo mergeSortDemo=new MergeSortDemo();

    }
}
