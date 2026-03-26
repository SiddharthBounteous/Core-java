package org.example.day4;
class Solution12{
    public void towerOfHanoi(int n,char startRod,char endRod,char auxRod){
        if(n==0){
            return;
        }
        towerOfHanoi(n - 1, startRod, auxRod, endRod);  //using end rod
        System.out.println("Disk "+n+" moved from "+startRod+" to " +endRod);
        towerOfHanoi(n - 1, auxRod, endRod, startRod);  //using start rod
    }
}
public class Question12 {
    static void main(String[] args) {
        Solution12 obj=new Solution12();
        obj.towerOfHanoi(3,'A','B','C');
    }
}
