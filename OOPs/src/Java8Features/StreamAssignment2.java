package Java8Features;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Book{
    private String title;
    private String author;
    private Integer year;
    private boolean isDigital;

    public Book(String title, String author, Integer year, boolean isDigital) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isDigital = isDigital;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }
}

class Order1{
    private int orderId;
    private String customerName;
    private double amount;
    private List<String>items;
    private String category;

    public Order1(int orderId, String customerName, double amount, List<String> items, String category) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.items = items;
        this.category = category;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
public class StreamAssignment2 {
    public static void main(String[] args) {
        List<Book> books=new ArrayList<>();

        books.add(new Book("Effective Java", "ABC", 2018, true));
        books.add(new Book("Clean Code", "ABC", 2008, false));
        books.add(new Book("Java Concurrency in Practice", "XYZ", 2006, true));
        books.add(new Book("Head First Java", "PQR", 2005, false));
        books.add(new Book("Spring in Action", "PQR", 2022, true));
        books.add(new Book("Dummy Book", "DEF", 2024, true));

        Map<String,List<Book>>mp=books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));

        mp.forEach((key,val)->{
            System.out.print(key);
            System.out.print(" ");
            val.forEach(b-> System.out.print(b.getTitle()+" "));
            System.out.println();
        });

        String oldestBook=books.stream()
                .min(Comparator.comparing(a->a.getYear()))
                .map(a->a.getTitle())
                .orElse("None");

        System.out.println(oldestBook);

        String books1=books.stream()
                .filter(e->e.getYear()>2020)
                .map(e->e.getTitle())
                .collect(Collectors.joining(","));
        System.out.println(books1);


        List<String> logs = Arrays.asList("123","456", "", null, "789", "error_404", "200", " ", "invalid_data", null, "999", "", "500_error", "42");

        List<String> filtered=logs.stream()
                .filter(e->(e!=null))
                .filter(e->!(e.isBlank()))
                .toList();

        for(String it:filtered){
            System.out.print(it+" ");
        }
        System.out.println();

        List<Integer> filtered1=logs.stream()
                .filter(e->(e!=null))
                .filter(s->!(s.isBlank()))
                .map(StreamAssignment2::check)
                .flatMap(Optional::stream)
                .toList();


        for(Integer it:filtered1){
            System.out.print(it+" ");
        }
        System.out.println();


        List<Order1> orders = Arrays.asList(
                new Order1(101, "Alice", 250.75, Arrays.asList("Laptop", "Mouse"), "Electronics"),
                new Order1(102, "Bob", 120.50, Arrays.asList("Shirt", "Jeans"), "Clothing"),
                new Order1(103, "Charlie", 560.00, Arrays.asList("Phone", "Charger", "Earbuds"), "Electronics"),
                new Order1(104, "David", 80.25, Arrays.asList("Book", "Notebook"), "Stationery"),
                new Order1(105, "Eve", 999.99, Arrays.asList("TV"), "Electronics"),
                new Order1(106, "Frank", 45.00, Arrays.asList("Pen", "Pencil"), "Stationery"),
                new Order1(107, "Grace", 300.00, Arrays.asList("Dress", "Shoes"), "Clothing"),
                new Order1(108, "Hannah", 150.75, Arrays.asList("Headphones"), "Electronics"),
                new Order1(109, "Ivy", 220.40, Arrays.asList("Bag", "Wallet"), "Accessories"),
                new Order1(110, "Jack", 75.60, Arrays.asList("Notebook", "Markers"), "Stationery")
        );

        Double sum=orders.stream()
                .collect(Collectors.summingDouble(o->o.getAmount()));

        List<String> unique=orders.stream().map(Order1::getItems)
                        .flatMap(o->o.stream()).distinct().toList();

        Map<String,Double>mp1=orders.stream().collect(Collectors.groupingBy(Order1::getCustomerName,Collectors.summingDouble(Order1::getAmount)));


        String topCategory=orders.stream()
                .collect(Collectors.groupingBy(
                        Order1::getCategory,
                        Collectors.summingDouble(Order1::getAmount)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");


        System.out.println(sum);
    }

    public static Optional<Integer> check(String s){
        try{
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
