package simulationWeiBo08131.t2;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    private int capacity;
    private int count;
    private LinkedList<Integer> list;
    private HashMap<Integer, Integer> map;

    public Solution(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
        count = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.offerLast(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            list.remove(key);
            list.offerLast(key);
        } else {
            count++;
            if (count > capacity) {
                count = capacity;
                int rmKey = list.removeFirst();
                map.remove(rmKey);
                map.put(key, value);
                list.offerLast(key);
            } else {
                map.put(key, value);
                list.offerLast(key);
            }
        }
    }

    public static void main(String[] args) {
        Solution cache = new Solution(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}