package Generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Print<Integer> p=new Print<>();
        p.setPrintValue(1);
        Integer printValue=p.getPrintValue();
        if(printValue==1){
            //do something
        }

        Paint<String> paintObj=new Paint<>();
        paintObj.setPrintValue("2");

        Pair<String,Integer>pairObj=new Pair<>();
        Pair<String,String>pairObj1=new Pair<>();
        pairObj.put("hello",1243);

        GenericMethod obj=new GenericMethod();
        obj.setValue(new Box());
        List<? extends Number>arr=new ArrayList<>();
        Integer t=10;
//        arr.add(t);  does not allow this because compiler does not know the type of data stored in this so its restricts the add method in the list
        List<Box>arr1=new ArrayList<>();
        arr1.add(new RectangleBox());

        Print<String>parametrizedTypePrintObject=new Print<>();

        //internally it passes Object as parametrized type
        Print rawTypePrintObject=new Print();
        rawTypePrintObject.setPrintValue(1);
        rawTypePrintObject.setPrintValue("hello");


        //multibounded
        List<? super Box> boxList=new ArrayList<>();
        List<? super Number> arr2=new ArrayList<>();

        arr2.add(10);
        boxList.add(new RectangleBox());
        boxList.add(new SquareBox());
        List<RectangleBox>rectangleBoxes=new ArrayList<>();
        List<SquareBox>squareBoxes=new ArrayList<>();

//        boxList=rectangleBoxes;   not valid

        Box box=new Box();
        RectangleBox rectangleBox=new RectangleBox();

        box=rectangleBox;

        MultiboundDemo multiboundDemo=new MultiboundDemo();
        multiboundDemo.setPrintValues(squareBoxes);
        multiboundDemo.setPrintValues(rectangleBoxes);
        multiboundDemo.setPrintValues1(rectangleBoxes);
        multiboundDemo.setPrintValues1(boxList);


        List<Integer> wildCardIntegerSourceList=new ArrayList<>();
        List<Float> wildCardIntegerDestinationList=new ArrayList<>();

        ComparingGenericWildCard printobj=new ComparingGenericWildCard();
        printobj.computeList(wildCardIntegerSourceList,wildCardIntegerDestinationList);
//        printobj.computeList1(wildCardIntegerSourceList,wildCardIntegerDestinationList);
    }
}
