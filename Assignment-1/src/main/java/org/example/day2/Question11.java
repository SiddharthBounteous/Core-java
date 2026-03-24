package org.example.day2;
class Solution11{
    int [][] directions={{0,1},{1,0},{0,-1},{-1,0},{1,-1},{-1,1},{1,1},{-1,-1}};
    public char[][] countAdjacentMines(char [][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;

        char[][] result=new char[n][m];
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='M'){
                    result[i][j]='M';
                }
                else{
                    for(int dir[]:directions){
                        int i_=i+dir[0];
                        int j_=j+dir[1];

                        if(i_>=0 && j_>=0 && i_<n && j_<m){
                            if(matrix[i_][j_]=='M'){
                                count++;
                            }
                        }
                    }
                    result[i][j]=(char)(count + '0');
                    count=0;
                }
            }
        }
        return result;
    }
}
public class Question11 {
    static void main(String[] args) {
        Solution11 obj=new Solution11();

        char [][] matrix={
                {'E','M','E'},
                {'E','E','M'},
                {'M','E','E'}
        };

        char [][] res=obj.countAdjacentMines(matrix);

        for(char [] it:res){
            for(char ele:it){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
