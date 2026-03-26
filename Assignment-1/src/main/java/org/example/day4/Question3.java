package org.example.day4;
class Solution3{
    public void modifyPrimitive(int n){
        n=99;
    }
    public void modifyArray(int [] arr){
        arr[0]=99;
    }
}
public class Question3 {
    static void main(String[] args) {
        int a=10;
        int [] arr={10,20};

        Solution3 obj=new Solution3();
        obj.modifyPrimitive(a);
        obj.modifyArray(arr);

        System.out.println(a);
        System.out.println(arr[0]);
    }
}
