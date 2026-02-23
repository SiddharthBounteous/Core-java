package Generics;

import java.util.List;

public class ComparingGenericWildCard {

    //wildCard method
    public void computeList(List<? extends Number> source,List<? extends Number> destination){

    }

    //generic type method
    public <T extends Number> void computeList1(List<T> source,List<T> destination){

    }
}
