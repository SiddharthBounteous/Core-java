package TypesOfClasses;

class OuterClass {
    int instanceVariable=10;
    static int classVariable =20;

    static class NestedClass{
        public void print(){
            System.out.println(classVariable);
        }
    }

    class Test{
        public void display(){
            System.out.println("Display");
        }
    }

    private static class NestedClass1{
        public void print(){
            System.out.println(classVariable);
        }
    }

    public void display(){
        NestedClass1 nestedObj=new NestedClass1();
        nestedObj.print();
    }
}

public class ObjectTest{
    public static void main(String[] args) {
        OuterClass.NestedClass nestedObj=new OuterClass.NestedClass();
        nestedObj.print();
        OuterClass obj=new OuterClass();
        OuterClass.Test t=obj.new Test();
        t.display();
    }
}