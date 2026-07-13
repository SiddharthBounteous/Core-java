package OOPSConcept;
class classA{
	public void display(int a,int b) {
		System.out.println(a+b);
	}
	public classA() {
		System.out.println("A Constructor");
	}
}
class classB extends classA{
	public void display(classB obj) {
		System.out.println("B");
	}
	public classB() {
//		super();
		//Java 25 supports Flexible Constructor Bodies.
        super();
		System.out.println("B Constructor");


	}
	
	public classB(String name) {
		this();
		System.out.println("name "+name);
		display(this);
	}
}
public class MainApp {
	public static void main(String[] args) {
//		classA objA=new classB();
//		objA.display(10, 20);
//		classB objB=new classB();
//		objB.display();
		
		classA ob1=new classA();
		classB ob2=new classB();
		classB ob3=new classB("Hi");
	}
}
