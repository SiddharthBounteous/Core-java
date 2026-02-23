package Generics;

public class Question2 {

    public static <T extends Comparable<T>> T findMax(T a, T b, T c){
        T max=a;
        if(b.compareTo(a)>0){
            if(b.compareTo(c)>0){
                max=b;
            }
            else{
                max=c;
            }
        }
        return max;
    }


    static void main(String[] args) {

        System.out.println(findMax(2,3,4));
        System.out.println(findMax(8.5,8.5,3.0));

        System.out.println(findMax("Siddharth","Hello","colour123"));
    }
}
