package ExeceptionHandling;

public class Main1 {
	public static void main(String args[]) {
		//class cast exception(run time)
		Object valObject=0;  //integer
		System.out.println((String)valObject);  //casting to string
	}
}
