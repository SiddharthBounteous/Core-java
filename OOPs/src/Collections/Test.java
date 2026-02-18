package Collections;

import java.util.Scanner;

public class Test {
    int index=0;
    public int[] add(int ele,int arr[]){
        if(index<arr.length){
            arr[index]=ele;
            index++;
            return arr;
        }
        else{
            arr=createNewArray(arr);
            arr[index]=ele;
            index++;
            return arr;
        }
    }
    public int [] createNewArray(int arr[]){
        int n=arr.length;
        int arr1[]=new int[n*2];
        for(int i=0;i<n;i++){
            arr1[i]=arr[i];
        }
        return arr1;
    }
    public int [] deleteElement(int ele,int arr[]){
        int n=arr.length;
        int pos=-1;
        for(int i=0;i<index;i++){
            if(arr[i]==ele){
                pos=i;
                break;
            }
        }

        if(pos==-1){
            System.out.println("Element not found");
            return arr;
        }

        for(int i=pos;i<index-1; i++){
            arr[i]=arr[i+1];
        }

        index--;
        System.out.println("Element deleted");
        return arr;
    }
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        n=sc.nextInt();

        int arr[]=new int[n];

        Test t=new Test();
        t.add(1, arr);
    }
}
