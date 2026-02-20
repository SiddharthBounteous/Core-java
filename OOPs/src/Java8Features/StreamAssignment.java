package Java8Features;

import java.util.*;
import java.util.stream.Collectors;
class Item{
    private String name;

    public Item(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Order{
    private int orderId;
    List<Item>items;

    public Order(int orderId, List<Item> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

public class StreamAssignment {
    public static void main(String[] args) {
        Employee ex1=new Employee(101,"Siddharth",100000,"Siddharth45@gmail.com","CSE");
        Employee ex2=new Employee(102,"Rahul",50000,"xyz@gmail.com","CSE");
        Employee ex3=new Employee(103,"Sohan",10000,"Sohan@gmail.com","Mechanical");
        Employee ex4=new Employee(104,"Mohan",155600,"Mohan@gmail.com","Electrical");
        Employee ex5=new Employee(105,"Karan",30000,"Karan@gmail.com","CSE");

        ex1.setSkills(List.of("Java", "Spring Boot", "SQL"));
        ex2.setSkills(List.of("Java", "C++"));
        ex3.setSkills(List.of("Java", "Spring Boot", "MongoDB"));
        ex4.setSkills(List.of("Java", "Rust", "System Design"));
        ex5.setSkills(List.of("C", "Python", "Machine Learning"));

        List<Integer>Numbers=List.of(1,2,3,4,5,6,7,8,9);
        List<List<Integer>>listoflist=new ArrayList<>();
        List<List<String>>items=new ArrayList<>();

//        List<List<String>>

        List<Integer>li1=List.of(10,20,30);
        List<Integer>li2=List.of(40,50,60);
        List<Integer>li3=List.of(70,80,90);
        listoflist.add(li1);
        listoflist.add(li2);
        listoflist.add(li3);

        List<String>sentences=List.of("An Apple a day keeps the doctor away",
                "Good things take time","The sun rises in the east");
        List<String>string1=List.of("Hi","Ashwini","Utsav","Siddharth");

        List<Order> orders = List.of(
                new Order(1, List.of(
                        new Item("Laptop"),
                        new Item("Mouse")
                )),
                new Order(2, List.of(
                        new Item("Keyboard"),
                        new Item("Monitor"),
                        new Item("USB Cable")
                )),
                new Order(3, List.of(
                        new Item("Headphones")
                ))
        );


        List<Employee> li=List.of(ex1,ex2,ex3,ex4,ex5);
        //1.
        String ans=li.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(ans);

        //2.
        Map<Integer,String> mp=li.stream().collect(Collectors.toMap(Employee::getEmployeeId,Employee::getName));
        System.out.println(mp);

        //3.
        Map<String,List<String>>EmployeeByDepartment=li.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
        System.out.println(EmployeeByDepartment);

        //4.
        Map<String,Long>countEmployeePerDept=li.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(countEmployeePerDept);

        //5.
        Map<String,Double>EmployeeByDepartmentWithSalary=li.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(EmployeeByDepartmentWithSalary);

        //6.
        Map<String,List<Integer>>getSeparated=Numbers.stream().collect(Collectors.groupingBy(n->n%2==0?"Even":"odd"));
        System.out.println(getSeparated);

        //7.
        Map<String,List<String>>partitionEmployee=li.stream().collect(Collectors.groupingBy(e->e.getSalary()>50000 ? "Salary greater than 50000":"Salary less than equal to 50000",Collectors.mapping(Employee::getName,Collectors.toList())));
        System.out.println(partitionEmployee);

        //8.
        Map<String,Integer>highestSalaryByDept=li.stream().collect(Collectors.toMap(Employee::getDepartment,Employee::getSalary,Integer::max));
        System.out.println(highestSalaryByDept);

        //9.
        System.out.println(EmployeeByDepartment);

        //10.
        System.out.println(EmployeeByDepartment);

        //11.
        List<Integer>normalList=listoflist.stream().flatMap(list->list.stream()).toList();
        System.out.println(normalList);

        //12.
        List<String>wordsfromSentences=sentences.stream().map(s->s.split(" ")).flatMap(Arrays::stream).toList();
        System.out.println(wordsfromSentences);

        //13.
        List<String>uniqueSkills=li.stream().flatMap(employee -> employee.getSkills().stream()).distinct().toList();
        System.out.println(uniqueSkills);

        //14.
        long totalItems=orders.stream().flatMap(o->o.getItems().stream()).count();
        System.out.println(totalItems);

        //15.
        int sum=listoflist.stream().flatMap(list->list.stream()).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //16.
        long prod=Numbers.stream().reduce((a,b)->a*b).orElse(0);
        System.out.println(prod);

        //17.
        String longest=string1.stream().reduce((a,b)->(a.length()>b.length() ? a : b)).orElse(" ");
        System.out.println(longest);

        //18.
        String concatenation=string1.stream().reduce((a,b)->a.concat(b)).orElse("");
        System.out.println(concatenation);

        //19.
        int salary=li.stream().map(Employee::getSalary).reduce((a,b)->(a>b?a:b)).orElse(0);
        System.out.println(salary);

        //20.
        Map<String,Integer>mp1=Map.of("Siddharth",12000,"Rahul",10000);
        Map<String,Integer>mp2=Map.of("Rohan",10000,"Sohan",15000,"Rahul",10000);
        List<Map<String,Integer>>listofMap=List.of(mp1,mp2);

        Map<String,Integer>mergedMap=listofMap.stream().reduce(new HashMap<>(),(m1,m2)->{
            m2.forEach((key,value)->{
                m1.merge(key,value,Integer::sum);
            });
            return m1;
        });
        System.out.println(mergedMap);

    }
}
