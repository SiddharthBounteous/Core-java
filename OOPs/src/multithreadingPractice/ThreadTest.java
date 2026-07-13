package multithreadingPractice;

import java.util.ArrayList;

public class ThreadTest {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(10);
        for(int num:arr){
            arr.add(10);
        }
    }
}

