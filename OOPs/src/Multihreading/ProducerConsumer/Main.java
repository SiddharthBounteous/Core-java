package Multihreading.ProducerConsumer;

import java.util.*;

class Employee{
    String id;
    String uniqueId;

    public Employee(String id, String uniqueId) {
        this.id = id;
        this.uniqueId = uniqueId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                '}';
    }
}
class Producer extends Thread{

    @Override
    public void run(){
        Random random=new Random();
        while(true){
            String randomId="ID-"+random.nextInt(3);
            String uuid=UUID.randomUUID().toString();
            Employee employee=new Employee(randomId,uuid);

            synchronized (Main.emp){
                while(Main.emp.size()==Main.capacity){
                    try{
                        Main.emp.wait();
                    }
                    catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }

                Main.emp.add(employee);
                System.out.println("Produced: " + employee.id + " | List size: " + Main.emp.size());

                Main.emp.notifyAll();

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
class Consumer extends Thread{
    @Override
    public void run(){
        while(true){
            synchronized (Main.emp){

                while(Main.emp.isEmpty()){
                    try{
                        Main.emp.wait();
                    }
                    catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }

                }

                Employee employee=Main.emp.remove(0);

                Main.mp.computeIfAbsent(employee.id, k->new ArrayList<>()).add(employee.uniqueId);
                System.out.println("Consumed: " + employee.id + " | Map currently has " + Main.mp.size() + " unique IDs");

                Main.emp.notifyAll();

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
public class Main {
    static List<Employee> emp=new ArrayList<>();
    static Map<String,List<String>> mp=new TreeMap<>();

    static final int capacity=5;

    static void main(String[] args) {

        Thread producer=new Producer();
        Thread consumer=new Consumer();

        producer.start();
        consumer.start();
    }
}
