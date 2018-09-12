package alg46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> numList =new ArrayList<>();
        dfs(numList,nums,0);
        return numList;
    }
    public void dfs(List<List<Integer>> res ,int nums[],int j){
        if(j==nums.length){
            List<Integer> tempNum =new ArrayList<>();
            for (int i = 0; i <nums.length ; i++) {
                tempNum.add(nums[i]);
            }
            res.add(tempNum);
        }
        for (int i = j; i <nums.length ; i++) {
            swapNum(nums,i,j);
            dfs(res,nums,j+1);
            swapNum(nums,i,j);
        }
    }
    public void swapNum(int[]nums ,int i,int j){
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3};
        Solution sol =new Solution();
        List<List<Integer>> numList=sol.permute(nums);
        for (int i = 0; i <numList.size() ; i++) {
            System.out.println(numList.get(i));
        }
    }

}
