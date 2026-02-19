package Java8Features;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {

    String name;
    int salary;
    String email;

    public Employee(String name, int salary, String email) {
        this.name = name;
        this.salary = salary;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        Employee ex1=new Employee("Siddharth",100000,"Siddharth45@gmail.com");
        Employee ex2=new Employee("Rahul",150000,"xyz@gmail.com");
        Employee ex3=new Employee("Sohan",130000,"Sohan@gmail.com");
        Employee ex4=new Employee("Mohan",155600,"Mohan@gmail.com");
        Employee ex5=new Employee("Karan",30000,"Karan@gmail.com");


        List<Employee>li=List.of(ex1,ex2,ex3,ex4,ex5);
        List<String>employeeList=li.stream().filter(e->e.getSalary()>30000).map(e->e.getName()).toList();
        List<String>employeeListSortedBySalary=li.stream().sorted(Comparator.comparing(e->e.getSalary())).map(e->e.getName()).toList();

        List<String>employeeListSortedBySalaryThenName=li.stream().sorted(Comparator.comparing(e->((Employee)e).getName()).thenComparing(e->((Employee)e).getSalary())).map(e->e.getName()).toList();
        System.out.println(employeeListSortedBySalaryThenName);
        System.out.println(employeeList);
        System.out.println(employeeListSortedBySalary);

        Map<String,String> emailSort=li.stream().collect(Collectors.toMap(Employee::getEmail,Employee::getName,(o, n)->n));

        System.out.println(emailSort);
    }
}
