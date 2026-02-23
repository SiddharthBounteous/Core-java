package Generics;

import java.util.List;

public class MultiboundDemo {
    public void setPrintValues(List<? extends Box> boxList){
        //it means Box and its child class
    }
    public void setPrintValues1(List<? super RectangleBox> boxList){
        //it means RectangleBox and its super class
    }
}
