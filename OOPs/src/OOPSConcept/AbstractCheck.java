package OOPSConcept;

class A{
	void display() {
		System.out.println("A");
	}
}
interface C{
	void check();
	default void display1() {
		System.out.println("C");
	}
}
abstract class B extends A implements C{
	@Override
	public void display1() {
		// TODO Auto-generated method stub
		System.out.println("B");
	}
	abstract void check1();
}
class D extends B implements C{

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void check1() {
		// TODO Auto-generated method stub
		
	}
	
}
public class AbstractCheck {
	public static void main(String[] args) {
		D objD=new D();
		objD.display1();
	}

}
