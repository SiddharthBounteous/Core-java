package OOPSConcept.relationship;

class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }
}

class Department {
    private Professor professor;

    Department(Professor professor) {
        this.professor = professor;
    }

    void display() {
        System.out.println("Professor: " + professor.name);
    }
}
public class WeakAssociation {
    public static void main(String[] args) {
        Professor p = new Professor("Deepak");

        Department d = new Department(p);

        d.display();
        //Professor ---------> Department
        //Professor is created outside.
        //Department only uses it.
        //If Department is destroyed, Professor can still exist.
    }
}
