package org.example.day4;

public class Question5 {
    public int stackOverflow(int count){
        return stackOverflow(count+1);
    }

    static void main(String[] args) {
        Question5 obj=new Question5();
        int ans=obj.stackOverflow(1);
        System.out.println(ans);
    }
}
