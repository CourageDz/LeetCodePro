package alg18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> fourSums=new ArrayList<>();
        int n=nums.length;
        if(n==0)return fourSums;
        int left,mid,right;
        for (int i = 0; i <n-3 ; i++) {
            if(i>0&&nums[i]==nums[i-1])//left不与i进行比较
                continue;
            int tg=target-nums[i];
            for (left = i+1; left <n-2 ; left++) {
                right=nums.length-1;
                if(left>i+1&&nums[left]==nums[left-1])//left不与i进行比较
                    continue;
                 mid =left+1;
                while(mid<right) {
                    if (tg == nums[left] + nums[right]+nums[mid]) {
                        fourSums.add(Arrays.asList(nums[i],nums[left],nums[mid],nums[right]));
                        while(mid<right&&nums[++mid]==nums[mid-1]);
                        while(mid<right&&nums[--right]==nums[right+1]);
                    }else if(tg>nums[left] + nums[right]+nums[mid]){
                        mid++;
                    }else
                        right--;
                }
            }
        }
        return fourSums;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Solution sol =new Solution();
        int [] num={-1,-5,-5,-3,2,5,0,4};
        List<List<Integer>> result=sol.fourSum(num,-7);
        System.out.println(result);
    }
}
