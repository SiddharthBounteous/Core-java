package OOPSConcept;
//class Solution{
//    Integer print(int i){
//        return 7;
//    }
//
//    String print(String s){
//        return s;
//    }
//    Integer print(int a,int b){
//        return a+b;
//    }
//
//    Float print(float a,int b){
//        return (a+b);
//    }
//}
class Parent{
    public static void print(){
        System.out.println("Parent");
    }
}
class Child extends Parent{
    public static void print(){
        System.out.println("Child");
    }
}
public class Main {
    public static void main() {
//        Solution obj=new Solution();
//
//        Integer a=obj.print(7);
//        String str=obj.print("7");
//        Integer ans=obj.print(6,7);
//        Float ans1=obj.print(6.5f,8);
//
//        System.out.println(a);
//        System.out.println(str);
//        System.out.println(ans);
//        System.out.println(ans1);

        Parent obj1=new Child();
        obj1.print();  //parent
    }
}
