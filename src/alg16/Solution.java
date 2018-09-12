package alg16;

import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int Min=999;
        for (int i = 0; i <nums.length ; i++) {
            int k=i+1,j=nums.length-1;
            int temp=target-nums[i];

            while (k<j){
                if(Math.abs(target-Min)>Math.abs(temp-nums[j]-nums[k]))
                    Min=nums[i]+nums[j]+nums[k];
                if(nums[j]+nums[k]==temp){
                    return Min;
                }else if (nums[j]+nums[k]<temp){
                    k++;
                }else
                    j--;
            }
        }
        return Min;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Solution sol =new Solution();
        int [] num={-1, 2, 1, -4};
        int result=sol.threeSumClosest(num,1);
        System.out.println(result);

    }
}
