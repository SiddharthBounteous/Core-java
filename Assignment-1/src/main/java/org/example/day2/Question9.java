package org.example.day2;

class Solution9{
    public void rotate(int[][] matrix){
        int n=matrix.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<n;i++){
            int l=0,r=n-1;
            while(l<r){
                int temp=matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=temp;
                l++;
                r--;
            }
        }
    }
}
public class Question9 {
    static void main(String[] args) {
        Solution9 obj=new Solution9();

        int matrix[][]={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        obj.rotate(matrix);

        for(int mat[]:matrix){
            for(int ele:mat){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
