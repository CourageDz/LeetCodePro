package alg220;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n=nums.length;
        if(k<1||t<0||n<=1){
            return false;
        }
        TreeSet<Integer> numsTree =new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int num=nums[i];
            if( ((numsTree).floor(num)!=null&&num<=t+numsTree.floor(num))|| (numsTree.ceiling(num)!=null &&numsTree.ceiling(num)-num<=t)){
                return true;
            }
            numsTree.add(num);
            if(i>=k){
                numsTree.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        int nums[]={1,5,9,1,5,9};
        boolean result=sol.containsNearbyAlmostDuplicate(nums,2,3);
        System.out.println(result);
    }
}
