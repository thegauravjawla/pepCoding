import java.util.*;
public class myhm<K, V>{
    class Pair{
        K key;
        V value;

        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Pair>[] buckets;
    int size = 0;
    
    public myhm(){
        buckets = new LinkedList[4];
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    public void put(K key, V value){
        int index = hashFunction(key);
        int indexInBucket = findInBucket(key, index);

        if(indexInBucket == -1){
            Pair nodeToPut = new Pair(key, value);
            buckets[index].add(nodeToPut);
            size++;
        }
        else{
            Pair nodeToModify = buckets[index].get(indexInBucket);
            nodeToModify.value = value;
        }

        double lambda = size * 1.0 / buckets.length;

        if(lambda > 2.0){
            rehash();
        }
    }

    private void rehash(){
        LinkedList<Pair>[] oldBucket = buckets;

        buckets = new LinkedList[oldBucket.length * 2];
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }

        size = 0;

        for(int i = 0; i < oldBucket.length; i++){
            for(Pair p: oldBucket[i]){
                put(p.key, p.value);
            }
        }
    }

    private int hashFunction(K key){
        int hashCode = key.hashCode(); //inbuilt function in java
        int index = Math.abs(hashCode) % buckets.length;
        return index;
    }

    private int findInBucket(K key, int index){
        int indexInBucket = 0;
        for(Pair p: buckets[index]){
            if(p.key.equals(key)){
                return indexInBucket;
            }
            indexInBucket++;
        }
        return -1;
    }


    public V get(K key){
        int index = hashFunction(key);
        int indexInBucket = findInBucket(key, index);
        if(indexInBucket == -1){
            return null;
        }
        else{
            return buckets[index].get(indexInBucket).value;
        }
    }

    public V remove(K key){
        int index = hashFunction(key);
        int indexInBucket = findInBucket(key, index);
        if(indexInBucket == -1){
            return null;
        }
        else{
            size--;
            return buckets[index].remove(indexInBucket).value;
        }
    }

    public boolean containsKey(K key){
        int index = hashFunction(key);
        int indexInBucket = findInBucket(key, index);
        if(indexInBucket == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public ArrayList<K> keySet(){
        ArrayList<K> keys = new ArrayList<>();
        for(int i = 0; i < buckets.length; i++){
            for(Pair p: buckets[i]){
                keys.add(p.key);
            }
        }
        return keys;
    }

    public void display(){
        for(int i = 0; i < buckets.length; i++){
            System.out.print("Bucket " + i + "->");
            for(Pair p: buckets[i]){
                System.out.print("[" + p.key + " + " + p.value + "], ");
            }
            System.out.println();
        }
    }
}
