package org.example.day4;
class Solution2{
    public double calculateAverage(double ...var){
        if(var.length==0){
            return 0.0;
        }

        double sum=0.0;

        for(double it:var){
            sum+=it;
        }

        return sum/var.length;
    }
}
public class Question2 {
    static void main(String[] args) {
        Solution2 obj=new Solution2();

        double ans1=obj.calculateAverage(1,2,3);
        double ans2=obj.calculateAverage(23);
        double ans3= obj.calculateAverage();
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}
