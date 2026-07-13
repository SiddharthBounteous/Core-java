package OOPSConcept.staticUse;

public class StaticDemo2 {
	// Static nested class
	static int count=1;
    static class Inner
    {
    	static int count=10;
        void show()
        {
        	//Java first looks for count inside the Inner class. Since Inner has its own count Inner.count
            System.out.println("Static nested class method.");
            count++;
            System.out.println(count);
        }
    }

    public static void main(String[] args)
    {
        // Creating an object of the static nested class
        StaticDemo2.Inner obj = new StaticDemo2.Inner();
        obj.show();
        System.out.println(Inner.count);
        System.out.println(StaticDemo2.count);
        System.out.println(count);
    }
}
