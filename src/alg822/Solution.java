package alg822;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int n=fronts.length;
        Set<Integer> same=new HashSet<>();

        for (int i = 0; i < n; i++) {
            if(fronts[i]==backs[i])
                same.add(fronts[i]);
        }
        int num=9999;
        for (int i = 0; i <n ; i++) {
            if(!same.contains(fronts[i]))
               num=Math.min(fronts[i],num);
            if(!same.contains(backs[i]))
                num=Math.min(backs[i],num);
        }
        return num%9999;
    }
    public static void main(String[] args) {
        int []fronts={2,2,5,1,2};
        int []backs={4,1,2,1,1};
        Solution sol =new Solution();
        int result=sol.flipgame(fronts,backs);
        System.out.println(result);
    }
}
