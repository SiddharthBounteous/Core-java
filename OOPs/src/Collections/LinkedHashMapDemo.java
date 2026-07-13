package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String>mp1=new LinkedHashMap();

        mp1.put(1,"a");
        mp1.put(2,"b");
        mp1.put(3,"c");
        mp1.put(5,"e");
        mp1.put(4,"d");

        mp1.get(3);

        System.out.println("For Map 1");
        for(Map.Entry<Integer,String> entryMap:mp1.entrySet()){
            Integer key=entryMap.getKey();
            String value=entryMap.getValue();
            System.out.println(key+" "+value);
        }

        //now follows LRU(it is pushed to back which is most used)
        LinkedHashMap<Integer,String>mp2=new LinkedHashMap(16,0.75f,true);

        mp2.put(1,"a");
        mp2.put(2,"b");
        mp2.put(3,"c");
        mp2.put(5,"e");
        mp2.put(4,"d");

        mp2.get(3);
        mp2.get(1);

        System.out.println("For Map 2");
        for(Map.Entry<Integer,String> entryMap:mp2.entrySet()){
            Integer key=entryMap.getKey();
            String value=entryMap.getValue();
            System.out.println(key+" "+value);
        }



    }
}
