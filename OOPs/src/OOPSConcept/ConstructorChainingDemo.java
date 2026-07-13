package OOPSConcept;

class AB{
	
	AB(){
		System.out.println("AB Constructor");
	}
}
class AC extends AB{
	AC(){
		this(10);
	}
	
	AC(int val){
		super();
	}
}
public class ConstructorChainingDemo {
	public static void main(String[] args) {
		
	}
}
