package alg31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        int j=nums.length-1;
        while (i>=0 && nums[i+1] <= nums[i]){
            i--;
        }
        if(i>=0){
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swamNums(nums,i,j);
        }
        reverseNums(nums,i+1);
    }
    public  void reverseNums(int []nums,int start){
        int n=nums.length-1;
        while (start<=n){
            swamNums(nums,start,n);
            start++;
            n--;
        }
    }
    public void swamNums(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        int []nums={1,2,3};
        sol.nextPermutation(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]+" ");

        }
    }
}
