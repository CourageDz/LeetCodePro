package alg517;

import sun.font.FontRunIterator;

import java.util.Arrays;

public class Solution {
    //time limit exceeded
    public int findMinMoves(int[] machines) {
            int sum=0,avg=0;
            int n=machines.length;
            for (int i = 0; i <n ; i++) {
                sum+=machines[i];
            }
            if(sum%n!=0)
                return -1;
            else
                avg=sum/n;
            int count=0;
            int  addNum[]=new int[n];
            Arrays.fill(addNum,0);
            while (true){
                boolean flag=true;
                for (int i = 0; i <n ; i++) {
                    machines[i]+=addNum[i];
                    if(machines[i]!=avg)
                        flag=false;
                }
                if(flag)
                    return count;
                Arrays.fill(addNum,0);
                int left= 0;
                count++;
                for (int i = 0; i <n ; i++) {
                    left+=machines[i]-avg;
                    if(left<0  && machines[i+1]>0){
                        addNum[i]++;
                        addNum[i+1]--;
                    }
                    if(left>0 && addNum[i]!=-1){
                        addNum[i]--;
                        addNum[i+1]++;
                    }
                }
            }
        }

    public static void main(String[] args) {
        Solution sol =new Solution();
        int []param={1,0,5};
        int result=sol.findMinMoves(param);
        System.out.println(result);
    }
}
