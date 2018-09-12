package alg731;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarTwo {
    List<int[]> calendar=new ArrayList<>();
    List<int[]> overlaps=new ArrayList<>();
    public MyCalendarTwo() {
    }

    public boolean book(int start, int end) {
        for (int[] iv: overlaps) {
            if(iv[0]<end && start<iv[1]){
                return false;
            }
        }
        for (int []iv:calendar) {
            if(iv[0]<end && start<iv[1]){
                overlaps.add(new int[]{ Math.max(start,iv[0]),Math.min(end,iv[1]) } );
            }
        }
        calendar.add(new int []{start,end});
        return true;
    }
    //用TreeMap解
    TreeMap<Integer, Integer> delta=new TreeMap<>();
    public boolean book2(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d: delta.values()) {
            active += d;
            if (active >= 3) {
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                if (delta.get(start) == 0)
                    delta.remove(start);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo=new MyCalendarTwo();

        boolean case1=myCalendarTwo.book(10,20);
        System.out.println(case1);

        boolean case2=myCalendarTwo.book(50,60);
        System.out.println(case2);

        boolean case3=myCalendarTwo.book(10,40);
        System.out.println(case3);

        boolean case4=myCalendarTwo.book(5,15);
        System.out.println(case4);

        boolean case5=myCalendarTwo.book(5,10);
        System.out.println(case5);

        boolean case6=myCalendarTwo.book(25,55);
        System.out.println(case6);

        boolean case7=myCalendarTwo.book(60,70);
        System.out.println(case7);
    }
}
