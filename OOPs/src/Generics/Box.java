package Generics;

import java.util.List;

public class Box <T>{
       T value;

       void setValue(T value){
           this.value=value;
       }

       T getValue(){
           return value;
       }
}

