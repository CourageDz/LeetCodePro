package alg630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)-> a[1]-b[1]);
        int n=courses.length;
        Integer [][]memo =new Integer[courses.length][courses[n-1][1]+1];
        for (int i = 0; i <memo.length ; i++) {
            Arrays.fill(memo[i],0);
        }
        return schedule(courses,0,0,memo);
    }
    public int schedule(int [][]courses,int i,int time ,Integer[][]memo){
        if(i==courses.length)
            return 0;
        if(memo[i][time]!=0){
            return memo[i][time];
        }else{
            int taken=0;
            if(time+courses[i][0]<=courses[i][1]){
                taken=1+schedule(courses,i+1,time+courses[i][0],memo);
            }
            int notTaken=schedule(courses,i+1,time,memo);
            memo[i][time]=Math.max(taken,notTaken);
            return memo[i][time];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int courses[][] = {{7, 17}, {3, 12}};
        int res = sol.scheduleCourse(courses);
        System.out.println(res);
    }
}


