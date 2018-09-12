package alg435;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length==0)
            return 0;
        Arrays.sort(intervals, (first,second)->{
            if(first.end==second.end)
                return first.start-second.start;
            else
                return first.end-second.end;
        });
        int n=intervals.length;
        int count=1;
        int k=0;
        for (int i = 1; i <n ; i++) {
            if(intervals[i].start>=intervals[k].end){
                count++;
                k=i;
            }
        }
        return n-count;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        Interval inter1=new Interval(1,2);
        Interval inter2=new Interval(3,4);
        Interval inter3=new Interval(4,6);
        Interval inter4=new Interval(3,5);
        Interval inter5=new Interval(2,4);
        Interval inter6=new Interval(7,9);
        Interval inter7=new Interval(1,7);
        Interval intervals[]={inter1,inter2,inter3,inter4,inter5,inter6,inter7};
        int result=sol.eraseOverlapIntervals(intervals);
        for (Interval interval:intervals) {
            System.out.println("start:"+interval.start+" "+"end:"+interval.end);
        }
        System.out.println("result:="+result);

    }
}
