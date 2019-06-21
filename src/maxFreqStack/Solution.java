package maxFreqStack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    class Node{
        private int key;
        private int value;
        private int count;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count=c++;
        }
    }
    private Queue<Node> queue=new PriorityQueue<>((a,b)->{
        if(a.value!=b.value){
            return b.value-a.value;
        }else {
            long res=b.count-a.count;
            return (int)res;
        }
    });
    private Map<Integer,Integer> map=new HashMap<>();
    private static int c=1;

    public void push(int x){
        int freq=map.getOrDefault(x,0);
        queue.offer(new Node(x,freq+1));
        map.put(x,freq+1);
    }

    public int pop(){
        Node top=queue.poll();
        if(top.value>=1){
            map.put(top.key,top.value-1);
        }else {
            map.put(top.key,0);
        }
        return top.key;
    }

    public static void main(String[] args) {
        Solution main=new Solution();
        main.push(5);
        main.push(7);
        main.push(5);
        main.push(7);
        main.push(4);
        main.push(5);

        System.out.println(main.pop());
        System.out.println(main.pop());
        System.out.println(main.pop());
        System.out.println(main.pop());
        System.out.println(main.pop());
        System.out.println(main.pop());


    }
}
