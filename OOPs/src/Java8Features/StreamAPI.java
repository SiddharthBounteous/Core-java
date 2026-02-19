package Java8Features;

import java.util.List;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer>li=List.of(1,2,3,4,5,6,7,8,1,2,5,51,45,90);

        List<Integer>filtered=li.stream()
                .filter(num->num%2==0).toList();

        System.out.println(filtered);
        List<Integer> li1=li.stream()
                .filter(num->(num>50)).toList();

        System.out.println(li1);


        List<String>names=List.of("Siddharth","Rahul","","Avinash");

        List<String>upperCase=names.stream().filter(n->n!=null).map(String::toUpperCase).toList();
        System.out.println(upperCase);

        List<Integer>lengthOfString=names.stream().map(s->s.length()).toList();
        System.out.println(lengthOfString);

        List<String>startWithA=names.stream().filter(s->s.startsWith("A")).toList();
        System.out.println(startWithA);

        List<Integer>squares=li.stream().map(n->n*n).toList();
        System.out.println(squares);

        List<Integer>sorted=li.stream().sorted().toList();
        System.out.println(sorted);

        List<Integer>duplicateRemove=li.stream().distinct().toList();
        System.out.println(duplicateRemove);


    }


}
