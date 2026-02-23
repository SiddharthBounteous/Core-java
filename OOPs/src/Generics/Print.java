package Generics;

public class Print <T>{
    T value;

    public T getPrintValue(){
        return value;
    }

    public void setPrintValue(T value){
        this.value=value;
    }
}
//non generic subclass
//you have to specifically define the type at the time of extending
class ColorPrint extends Print<String>{

}

//generic subclass extending
//not needed to specify now
class Paint<T> extends Print<T>{

}