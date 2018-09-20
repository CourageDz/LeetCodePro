package alg56;

import sun.java2d.pipe.SolidTextRenderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        int n= intervals.size();
        List<Interval> mergedIntervals=new ArrayList<>();
        if(n==0)
            return mergedIntervals;
        Collections.sort(intervals,(a,b)->a.start-b.start);
        int minStart=Integer.MAX_VALUE;int maxEnd=Integer.MIN_VALUE;
        for(Interval interval:intervals){
            if(minStart==Integer.MAX_VALUE){
                minStart=interval.start;
                maxEnd=interval.end;
            }else if(maxEnd<interval.end && maxEnd>=interval.start){
                maxEnd=interval.end;
            }else if(maxEnd<interval.start){
                mergedIntervals.add(new Interval(minStart,maxEnd));
                minStart=interval.start;
                maxEnd=interval.end;
            }
        }
        mergedIntervals.add(new Interval(minStart,maxEnd));
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals=new ArrayList<>();
        Interval interval1 =new Interval(1,3);
        Interval interval2 =new Interval(0,3);
//        Interval interval3 =new Interval(8,10);
//        Interval interval4 =new Interval(15,18);
//        Interval interval5=new Interval(1,10);

        intervals.add(interval1);
        intervals.add(interval2);
//        intervals.add(interval3);
//        intervals.add(interval4);
//        intervals.add(interval5);
        Solution sol =new Solution();
        List<Interval>result=sol.merge(intervals);
        for(Interval interval:result){
            System.out.println("["+interval.start+"  "+interval.end+"]");
        }
    }
}
