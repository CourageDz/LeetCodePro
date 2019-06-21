package maxFreqStack;


import java.util.*;

/***
 * 	最大频率栈
 * 	实现 FreqStack，模拟类似栈的数据结构的操作的一个类。FreqStack 有两个函数： push(int x)，将整数 x 推入栈中。pop()，它移除并返回栈中出现最频繁的元素。如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 * 	◼ 示例：
 * 	push [5,7,5,7,4,5]
 * 	pop() -> 返回 5，因为 5 是出现频率最高的。 栈变成 [5,7,5,7,4]。
 * 	pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。 栈变成 [5,7,5,4]。
 * 	pop() -> 返回 5 。 栈变成 [5,7,4]。
 * pop() -> 返回 4 。 栈变成 [5,7]。
 */
public class Main {
    class Node{
        private int key;
        private int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Queue<Node> queue=new PriorityQueue<>((a,b)->b.value-a.value);
    private Map<Integer,Integer> map=new HashMap<>();
    private Deque<Integer> q1=new LinkedList<>();
    private Deque<Integer> q2=new LinkedList<>();

    private void push(int key){
        map.put(key,map.getOrDefault(key,0)+1);
        queue.offer(new Node(key,map.get(key)));
        q1.offerLast(key);
    }

    private int pop(){
        Node top=queue.poll();
        int freq=top.value;
        while (!q1.isEmpty()){
            int key=q1.pollLast();
            if(map.get(key)==freq){
                map.put(key,freq-1);
                while (!q2.isEmpty()){
                    q1.offerLast(q2.pollFirst());
                }
                return key;
            }else {
                q2.offerFirst(key);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Main main=new Main();
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
