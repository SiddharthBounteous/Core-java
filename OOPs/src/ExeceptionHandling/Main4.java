package ExeceptionHandling;


public class Main4 {
	public static void main(String[] args) {
		try {
			method1("dummy");
		}
//		catch(ClassNotFoundException ex) {
//			//handle it
//		}
//		catch (InterruptedException ex) {
//			//handle exception
//		}
		catch(ClassNotFoundException | InterruptedException ex) {
			
		}
//		catch(FileNotFoundException ex) {  //unreachable catch block
//			
//		}
	}

	private static void method1(String name) throws ClassNotFoundException,InterruptedException{
		// TODO Auto-generated method stub
		if(name.equals("dummy")) {
			throw new ClassNotFoundException();
		}
		else if(name.equals("interrupted")) {
			throw new InterruptedException();
		}
	}
}
