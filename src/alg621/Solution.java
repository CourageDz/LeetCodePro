package alg621;

import java.util.*;

public class Solution {
    /*首先应该处理的出现次数最多的那个任务，先确定好这些高频任务，然后再来安排那些低频任务。如果任务F的出现频率最高，为k次，那么我们用n个空位将每两个F分隔开，然后我们按顺序加入其他低频的任务，来看一个例子：
    AAAABBBEEFFGG 3
    我们发现任务A出现了4次，频率最高，于是我们在每个A中间加入三个空位，如下：
    A---A---A---A
    AB--AB--AB--A   (加入B)
    ABE-ABE-AB--A   (加入E)
    ABEFABE-ABF-A   (加入F，每次尽可能填满或者是均匀填充)
    ABEFABEGABFGA   (加入G)*/
    public int leastInterval(char[] tasks, int n) {

        Map<Character,Integer> taskPeriod=new HashMap<>();
        Integer []taskIsComp=new Integer [26];
        Arrays.fill(taskIsComp,0);
        char task;
        int i,count=0,allCount=0,mx=0;

        for ( i = 0; i < tasks.length; i++) {
            taskPeriod.put(tasks[i],0);
            taskIsComp[tasks[i]-'A']++;
        }

        Arrays.sort(taskIsComp,Collections.<Integer>reverseOrder());
        for ( i = 0; i < tasks.length; i++){
            mx=taskIsComp[0];
            if(taskIsComp[i]==mx){
                count++;
            }
        }
        allCount=Math.max(tasks.length,(n+1)*(mx-1)+count);
        return allCount;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        String s= "AAAABBBBCCCDSDFFS";
        char []tasks=s.toCharArray();
        int result=sol.leastInterval(tasks,6);
        System.out.println(result);
    }
}
