package alg453;

import java.util.Arrays;

public class Solution {
    public int minMoves(int[] nums) {
        int minNum = nums[0];
        for (int i = 1; i < nums.length; ++i)
        {
            minNum = Math.min(minNum, nums[i]);
        }
        int result = 0;
        for (int  num : nums)
        {
            result += num - minNum;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution sol =new Solution();
        int nums[]={1,2,3};
        int result=sol.minMoves(nums);
        System.out.println(result);
    }

}
