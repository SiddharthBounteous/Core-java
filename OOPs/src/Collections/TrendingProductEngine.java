package Collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TrendingProductEngine {
    //take new orders and then old orders will be deleted from front
    Queue<OrderEvent>orderWindow=new ConcurrentLinkedQueue<>();
    //for maintaining order count of the product
    ConcurrentHashMap<String,Long>productCounterMap=new ConcurrentHashMap<>();

    //to maintain {region->{category->count}}
    ConcurrentHashMap<String,ConcurrentHashMap<String,Long>>regionCategoryCount=new ConcurrentHashMap<>();

    //start processing orders
    public void processOrder(OrderEvent event){
        orderWindow.add(event);

        //merge prevents race conditions
        //if key exists add 1 to current value
        productCounterMap.merge(event.getProductId(),1L,Long::sum);

        //update category count
        //get region
        ConcurrentHashMap<String,Long>categoryMap=regionCategoryCount.computeIfAbsent(event.getRegion(),k->new ConcurrentHashMap<>());

        categoryMap.merge(event.getCategory(),1L,Long::sum);

        //cleanup
        removeExpiredEvents();
    }

    public void removeExpiredEvents(){
        long currentTime=System.currentTimeMillis();
        long windowTime=10*60*1000;

        while(!orderWindow.isEmpty()){
            OrderEvent oldestEvent=orderWindow.peek();

            //less than 10 min
            if(currentTime-oldestEvent.getTimeStamp()<windowTime){
                break;
            }

            //10 min passed
            orderWindow.poll();

            //decrement product count
            //if key exists then subtracts 1 otherwise removes key
            productCounterMap.computeIfPresent(oldestEvent.getProductId(),(key,value)->{
               long newValue=value-1;

               return (newValue<=0) ? null : newValue;
            });

            //decrement category count
            ConcurrentHashMap<String,Long>catMap=regionCategoryCount.get(oldestEvent.getRegion());
            if(catMap!= null){
                catMap.computeIfPresent(oldestEvent.getCategory(), (key, val)->{
                    long newVal=val-1;
                    return (newVal <= 0) ? null : newVal;
                });
            }
        }
    }

    //top trending products
    public List<String> getTopTrendingProducts(int limit){
        PriorityQueue<Map.Entry<String,Long>>heap=new PriorityQueue<>(
                Map.Entry.comparingByValue()
        );

        for(Map.Entry<String,Long>entry : productCounterMap.entrySet()) {
            heap.offer(entry);
            //if more than limit, remove smallest one
            if(heap.size()>limit){
                heap.poll();
            }
        }
        List<String>result=new ArrayList<>();
        while(!heap.isEmpty()){
            result.add(heap.poll().getKey());
        }
        //reverse to highest count
        Collections.reverse(result);
        return result;
    }

    public List<String> getTopTrendingCategories(String region, int limit){
        ConcurrentHashMap<String,Long>catMap=regionCategoryCount.get(region);

        //If no sales in this region, return empty list
        if(catMap==null) return Collections.emptyList();


        PriorityQueue<Map.Entry<String,Long>>heap=new PriorityQueue<>(
                Map.Entry.comparingByValue()
        );

        for(Map.Entry<String,Long>entry : catMap.entrySet()) {
            heap.offer(entry);
            if(heap.size()>limit){
                heap.poll();
            }
        }

        List<String>result=new ArrayList<>();
        while(!heap.isEmpty()){
            result.add(heap.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }
}
