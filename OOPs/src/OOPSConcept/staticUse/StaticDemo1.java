package OOPSConcept.staticUse;


class Student
{
    String name;
    int rollNo;
    static String schoolName = "ABC Public School";  // static variable shared by all students
    static int count=0;
    static int count1;
    // Constructor
    Student(String name, int rollNo)
    {
        this.name = name;
        this.rollNo = rollNo;
    }

    // Method to display student details
    void displayDetails()
    {
        System.out.println("Name     : " + name);
        System.out.println("Roll No  : " + rollNo);
        System.out.println("School   : " + schoolName);
        System.out.println("--------------------------");
        count++;
        count1++;
    }
    
    static {
    	System.out.println("Static block executed.");
    	schoolName="Hi";
    	count1=100;
    }
    
    static void greet()
    {
        System.out.println("Hello! This is a static method.");
    }
}
public class StaticDemo1 {
	public static void main(String [] args) {
		 Student s1 = new Student("Amit", 101);
	     Student s2 = new Student("Deepak", 102);
	     Student s3 = new Student("Rahul", 103);

	     // Displaying student details
	     s1.displayDetails();
	     s2.displayDetails();
	     s3.displayDetails();
	     System.out.println(Student.count);
	     s1.greet();
	     Student.greet();
	     System.out.println(Student.count1);
	}
}
