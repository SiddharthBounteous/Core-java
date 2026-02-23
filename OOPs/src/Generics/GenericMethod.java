package Generics;

public class GenericMethod {
    public <K,V> void printValue(Pair<K,V> pair1,Pair<K,V> pair2){
        if(pair2.getKey().equals(pair2.getKey())){
            //do something
        }
    }

    public <T> void setValue(T object){
        //do something
    }

}
