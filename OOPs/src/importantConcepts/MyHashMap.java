package importantConcepts;


public class MyHashMap <K,V>{
    private static final int INITIAL_SIZE=1<<4;  //16
    private static final int MAXIMUM_CAPACITY=1<<30;

    public Entry[] hashTable;

    public MyHashMap(){
        hashTable=new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity){
        int tableSize=tableSizeFor(capacity);
        hashTable=new Entry[tableSize];
    }

    //given some capacity this function will calculate its nearest largest capacity
    final int tableSizeFor(int cap){
        int n=cap-1;
        n |= n>>>1;
        n |= n>>>2;
        n |= n>>>4;
        n |= n>>>8;
        n |= n>>>16;

        return (n<0) ? 1: (n>=MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY:n+1;
    }

    class Entry<K,V>{
        public K key;
        public V value;
        public Entry next;

        Entry(K k,V v){
            key=k;
            value=v;
        }

    }

    public void put(K key,V value){
        //should be within table size that's why we are doing modulus
        int hashCode=key.hashCode()%hashTable.length;
        Entry node=hashTable[hashCode];

        if(node==null){
            Entry newNode=new Entry(key,value);
            hashTable[hashCode]=newNode;
        }
        else{
            //collision happened
            /**
             * key same: override value
             * key not same:  go next-next and add at the end
             * **/
            Entry previousNode=node;
            while(node!=null){
                if(node.key==key){
                    node.value=value;
                    return;
                }
                previousNode=node;
                node=node.next;
            }
            Entry newNode=new Entry(key,value);
            previousNode.next=newNode;
        }
    }

    public V get(K key){
        int hashCode=key.hashCode()%hashTable.length;
        Entry node=hashTable[hashCode];

        while(node!=null){
            if(node.key.equals(key)){
                return (V) node.value;
            }
            node=node.next;
        }
        return null;
    }

    public static  void main(String[] args){
        MyHashMap<Integer,String>mp=new MyHashMap<Integer,String>(7);

        mp.put(1,"Hi");
        mp.put(2,"Siddharth");
        mp.put(3,"my");
        mp.put(4,"name");
        mp.put(5,"is");
        mp.put(6,"I");
        mp.put(7,"love");
        mp.put(8,"coding");
        mp.put(9,"in");
        mp.put(10,"java");

        String value=mp.get(8);
        System.out.println(value);
    }
}
