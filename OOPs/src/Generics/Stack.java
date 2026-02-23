package Generics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack <T>{
    Object arr[];
    private static final int default_capacity=10;
    int size;

    public Stack() {
        arr=new Object[default_capacity];
        size=0;
    }

    public void push(T val){
        if(arr.length==default_capacity){
            resize();
        }
        arr[size]=val;
        size++;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    public void resize(){
        int newCapacity=arr.length*2;
        arr= Arrays.copyOf(arr,newCapacity);
    }

    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T val=(T)arr[size-1];
        size--;
        arr[size]=null;
        return val;
    }

    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T val=(T)arr[size-1];
        return val;
    }
}
