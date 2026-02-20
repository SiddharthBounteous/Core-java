package Java8Features;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {

    private int employeeId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    private String name;
    private int salary;
    private String email;
    private String department;
    private List<String> skills;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Employee(int employeeId,String name, int salary, String email,String department) {
        this.employeeId=employeeId;
        this.name = name;
        this.salary = salary;
        this.email=email;
        this.department=department;
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
        Employee ex1=new Employee(1,"Siddharth",100000,"Siddharth45@gmail.com","CSE");
        Employee ex2=new Employee(2,"Rahul",150000,"xyz@gmail.com","CSE");
        Employee ex3=new Employee(3,"Sohan",130000,"Sohan@gmail.com","Mechanical");
        Employee ex4=new Employee(4,"Mohan",155600,"Mohan@gmail.com","Electrical");
        Employee ex5=new Employee(5,"Karan",30000,"Karan@gmail.com","CSE");

        ex1.setSkills(List.of("Java", "Spring Boot", "SQL"));
        ex2.setSkills(List.of("Java", "C++"));
        ex3.setSkills(List.of("Java", "Spring Boot", "MongoDB"));
        ex4.setSkills(List.of("Java", "Rust", "System Design"));
        ex5.setSkills(List.of("C", "Python", "Machine Learning"));


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
