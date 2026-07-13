package Collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Employee{
    String name;
    int id;

    Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
public class TreeSetImpl {
    public static void main() {

        Set<Employee>st=new TreeSet<>((e1,e2)->e1.id-e2.id);
        st.add(new Employee("Siddharth",45));
        st.add(new Employee("Rahul",40));
        st.add(new Employee("Rohan",41));

        System.out.println(st);
    }
}
