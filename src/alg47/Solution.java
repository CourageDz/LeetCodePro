package alg47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        Set<Integer> appeard=new HashSet();
        for (int i = j; i <nums.length ; i++) {
            if(appeard.add(nums[i])){
                swapNum(nums,i,j);
                dfs(res,nums,j+1);
                swapNum(nums,i,j);
            }
        }
    }
    public void swapNum(int[]nums ,int i,int j){
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int nums[]={1,1,3};
        Solution sol =new Solution();
        List<List<Integer>> numList=sol.permuteUnique(nums);
        for (int i = 0; i <numList.size() ; i++) {
            System.out.println(numList.get(i));
        }
    }
}
