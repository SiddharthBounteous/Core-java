package Collections;

import java.util.ArrayList;
import java.util.Stack;

final class ImmutableList<T>{
    private final Object [] elements;

    //we are copying the elements of original array to new array to create a copy
    ImmutableList(Object[] input) {
        elements=new Object[input.length];

        for(int i=0;i<elements.length;i++){
            elements[i]=input[i];
        }
    }

    public T get(int index){
        if(index<0 || index>elements.length){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        return (T) elements[index];
    }

    public void printList(){
        for(int i=0;i<elements.length;i++){
            System.out.println(elements[i]);
        }
    }
}
public class ImmutableListDemo {

    public static void main(String[] args) {
        Integer [] num={1,2,3,4,5};
        ImmutableList<Integer> arr=new ImmutableList<>(num);
        System.out.println("arr before reassignment: " + System.identityHashCode(arr));
        arr.printList();

        num[0]=0;

        arr=new ImmutableList<>(num);
        //arr now points to new object
        System.out.println("arr after reassignment: " + System.identityHashCode(arr));
        System.out.println("-------------------------");

        arr.printList();


    }
}
