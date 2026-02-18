package Collections;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    int M;//no. of buckets
    List<LinkedList<Integer>> buckets;
    int count;

    int getIndex(int key){
        key=Math.abs(key);
        return key%M;
    }

    public HashTable() {
        M=3;
        count=0;
        buckets=new ArrayList<>(M);


        for(int i=0;i<M;i++){
            buckets.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        int index=getIndex(key);

        LinkedList<Integer>bucket=buckets.get(index);

        if(!bucket.contains(key)){
            bucket.add(key);
            count++;
        }

        if((double) count/M>=0.75){
            rehash();
        }

    }

    public void remove(int key) {
        int index=getIndex(key);

        LinkedList<Integer>bucket=buckets.get(index);

        if(bucket.contains(key)){
            bucket.remove(Integer.valueOf(key));
            count--;
        }
    }

    public boolean contains(int key) {
        int index=getIndex(key);

        LinkedList<Integer>bucket=buckets.get(index);
        return bucket.contains(key);
    }

    public void rehash(){
        List<LinkedList<Integer>>oldBuckets=buckets;

        M=M*2;

        count=0;
        buckets=new ArrayList<>(M);

        for(int i=0;i<M;i++){
            buckets.add(new LinkedList<>());
        }

        for(LinkedList<Integer>oldBucket:oldBuckets){
            for(int key:oldBucket){
                add(key);
            }
        }
    }

//    public void display(){
//        for(int i=0;i<M;i++){
//            LinkedList<Integer>it=buckets.get(i);
//
//            if(!it.isEmpty()){
//                System.out.print(i);
//
//                for(Integer x:it){
//                    System.out.print(x+",");
//                }
//
//            }
//
//        }


    public static void main(String[] args) {
        HashTable ht=new HashTable();

        ht.add(1);
        ht.add(2);
        ht.add(3);
        ht.add(1);
        ht.add(4);

        boolean a1=ht.contains(1);
        boolean a2=ht.contains(3);

        System.out.println(a1);
        System.out.println(a2);

//        ht.display();
    }
}
