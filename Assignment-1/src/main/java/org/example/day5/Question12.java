package org.example.day5;

import java.util.ArrayList;
import java.util.List;

class MenuItem{
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
class Order{
    private int itemCount;
    private MenuItem[] items=new MenuItem[10];

    public void addMenuItem(MenuItem item){
        if(itemCount<10){
            items[itemCount]=item;
            itemCount++;
        }
        else{
            System.out.println("Order is full!");
        }
    }

    public double calculateTotal(){
        double total=0.0;
        for(int i=0;i<itemCount;i++){
            total+=items[i].getPrice();
        }
        return total;
    }

    public void printReceipt(){
        System.out.println("----- Receipt -----");

        for (int i=0;i<itemCount;i++){
            System.out.println(items[i].getName()+" - "+items[i].getPrice());
        }

        System.out.println("-------------------");
        System.out.println("Total: "+calculateTotal());
    }
}
public class Question12 {
    public static void main(String[] args) {
        MenuItem item1=new MenuItem("Coffee",50);
        MenuItem item2=new MenuItem("Sandwich",120);
        MenuItem item3=new MenuItem("Cake",80);

        Order order=new Order();
        order.addMenuItem(item1);
        order.addMenuItem(item2);
        order.addMenuItem(item3);

        order.printReceipt();
    }

}
