package OOPSConcept.relationship;

import Generics.Print;

// Dependent class
class Whiteboard
{
    void writeOnBoard()
    {
        System.out.println("Writing on the whiteboard...");
    }
}

// Main class that uses Whiteboard
class Teacher
{
    void teachLesson()
    {
        // Local variable: Dependency created inside the method
        Whiteboard board = new Whiteboard();
        board.writeOnBoard();  // Temporary usage
        System.out.println("Teacher is explaining the topic.");
    }
}
// Dependent class
class Printer
{
    void printDocument()
    {
        System.out.println("Printing document...");
    }
}

// Main class that depends on Printer
class OfficeWorker
{
    // Dependency injected via method parameter
    void performTask(Printer printer)
    {
        printer.printDocument();  // Temporary usage
        System.out.println("OfficeWorker has completed printing task.");
    }
}
public class DependencyRelationship {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.teachLesson();  // Trigger method that shows dependency
        Printer printer=new Printer();
        printer.printDocument();

        OfficeWorker officeWorker=new OfficeWorker();
        officeWorker.performTask(printer);
    }
}
