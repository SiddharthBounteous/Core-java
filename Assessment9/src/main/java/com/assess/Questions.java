package com.assess;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Questions {
    static void main(String[] args) {
        Employee e1 = new Employee(1, "Alice");
        Employee e2 = new Employee(2, "Bob");
        Employee e3 = new Employee(3, "Charlie");

        List<Employee> itEmployees = Arrays.asList(e1, e2);
        List<Employee> hrEmployees = Arrays.asList(e3);

        Department it = new Department("IT", itEmployees);
        Department hr = new Department("HR", hrEmployees);

        List<Department> departments = Arrays.asList(it, hr);

        //1
        List<Employee>list=departments.stream()
                .flatMap(d->d.getEmployees().stream())
                .toList();

        list.forEach(e-> System.out.println(e.getName()));

        //2
        List<Employee>list2=departments.stream()
                .flatMap(e->e.getEmployees().stream())
                .filter(g->g.getName().startsWith(String.valueOf('A'))).toList();

        //3
        List<Employee>list3=departments.stream()
                .flatMap(e->e.getEmployees().stream()).sorted(Comparator.comparing(Employee::getName)).toList();


    }
}
