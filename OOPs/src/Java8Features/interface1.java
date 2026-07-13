package Java8Features;

import OOPSConcept.Interface1;

import java.util.Comparator;
import java.util.concurrent.Callable;

@FunctionalInterface
interface interface1{

    int cal(int a,int b);
    default int cal1(int c){
        return c;
    }
}

class class1{

    static void main(String[] args) {

        interface1 ans=(a, b)->{
            int sum=0;
            for(int i=1;i<=a;i++){
                sum+=b;
            }
            return sum;
        };
        System.out.println(ans.cal(4,5));
    }
}
