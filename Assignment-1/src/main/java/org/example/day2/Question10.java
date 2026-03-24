package org.example.day2;
class Solution10{
    public int[][] solveMatrix(int matrix1[][],int matrix2[][]){
        int m1=matrix1.length;
        int n1=matrix1[0].length;

        int m2=matrix2.length;
        int n2=matrix2[0].length;
        int result[][]=new int[m1][n2];

        if(n1==m2){
            for(int i=0;i<m1;i++) {
                for (int j=0;j<n2;j++) {
                    int sum=0;
                    for (int k=0;k<n1;k++) {
                        sum+=matrix1[i][k] * matrix2[k][j];
                    }

                    result[i][j]=sum;
                }
            }
        }
        else {
            System.out.println("Matrix multiplication not possible: Columns of matrix 1 must equal rows of matrix 2");
        }
        return result;
    }
}
public class Question10 {
    static void main(String[] args) {
        Solution10 obj=new Solution10();
        int matrix1[][]={
                {1,2},
                {4,5}
        };
        int matrxi2[][]={
                {4,5,6},
                {7,8,9}
        };

        int result[][]=obj.solveMatrix(matrix1,matrxi2);

        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
