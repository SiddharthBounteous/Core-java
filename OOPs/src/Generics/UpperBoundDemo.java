package Generics;

public class UpperBoundDemo<T extends Number> {
    T value;

    public T getPrintValue(){
        return value;
    }

    public void setPrintValue(T value){
        this.value=value;
    }
}
