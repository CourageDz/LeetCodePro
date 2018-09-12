package alg432;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class AllOne {


    class Bucket{
        int count ;
        Bucket pre;
        Bucket next;
        Set<String> keys;
        Bucket(int cnt){
            count=cnt;
            keys=new HashSet<>();
        }
    }
    Bucket head;
    Bucket tail;
    private Map<Integer,Bucket> interMapBucket;
    private Map<String,Integer>keyCountMap;

    /** Initialize your data structure here. */
    public AllOne() {
        this.head=new Bucket(Integer.MIN_VALUE);
        this.tail=new Bucket(Integer.MAX_VALUE);
        this.head.next=this.tail;
        this.tail.pre=this.head;
        interMapBucket =new HashMap<>();
        keyCountMap=new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(!keyCountMap.containsKey(key)){
            keyCountMap.put(key,1);
            if(head.next.count!=1){
                addBucketAfter(new Bucket(1),head);
            }
            head.next.keys.add(key);
            interMapBucket.put(1,head.next);
        }else {
            changeKey(key,1);
        }

    }
    public void changeKey(String key,int offset){
        int count=keyCountMap.get(key);
        keyCountMap.put(key,count+offset);
        Bucket curBucket=interMapBucket.get(count);
        Bucket newBucket;
        if(!interMapBucket.containsKey(count+offset)){
            newBucket= new Bucket(count+offset);
            interMapBucket.put(count+offset,newBucket);
            addBucketAfter(newBucket,offset==1?curBucket:curBucket.pre);
        }else {
            newBucket=interMapBucket.get(count+offset);
        }
        newBucket.keys.add(key);
        removeKeyFromBucket(curBucket,key);
    }
    public void removeKeyFromBucket(Bucket bucket,String key){
        bucket.keys.remove(key);
        if(bucket.keys.isEmpty()){
            removeBucketFromList(bucket);
            interMapBucket.remove(bucket.count);
        }
    }
    public void removeBucketFromList(Bucket bucket){
        bucket.pre.next=bucket.next;
        bucket.next.pre=bucket.pre;
        bucket.pre=null;
        bucket.next=null;
    }

    public void addBucketAfter(Bucket bucket,Bucket preBucket){
        bucket.next=preBucket.next;
        bucket.pre=preBucket;
        preBucket.next.pre=bucket;
        preBucket.next=bucket;
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(keyCountMap.containsKey(key)){
            int count=keyCountMap.get(key);
            if(count==1){
                removeKeyFromBucket(interMapBucket.get(1),key);
                keyCountMap.remove(key);
            }
            else {
                changeKey(key,-1);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.pre==head ? "":tail.pre.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next==tail? "": head.next.keys.iterator().next();
    }

    public static void main(String[] args) {
        AllOne sol=new AllOne();
        for (int i = 1; i <=9 ; i++) {
            sol.inc("x"+i);
        }
        for (int i = 3; i <=9 ; i++) {
            sol.inc("x"+i);
        }
        sol.inc("x1");
        sol.inc("x1");
        sol.inc("x3");
        System.out.println(sol.getMaxKey());
        System.out.println(sol.getMinKey());

    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
