package org.example.day5;

//Utility class = only static methods + no objects
class MathUtils{
    private MathUtils(){

    }

    public static boolean isEven(int n){
        return n%2==0;
    }

    public static int factorial(int n){
        int res=1;
        for(int i=1;i<=n;i++){
            res*=i;
        }

        return res;
    }

    public static int max(int a,int b){
        return Math.max(a,b);   //a utility class
    }
}
public class Question11 {
    static void main(String[] args) {
        int ans1=MathUtils.factorial(5);
        boolean ans2=MathUtils.isEven(4);
        int ans3=MathUtils.max(6,4);

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}
