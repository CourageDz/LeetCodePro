package alg90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> subSets = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        dfs(subSets, set, 0, nums);
        return subSets;
    }

    public void dfs(List<List<Integer>> subSets, List<Integer> set, int pos, int[] nums) {
        if (pos <= nums.length)
            subSets.add(set);
        int i = pos;
        while (i < nums.length) {
            set.add(nums[i]);
            dfs(subSets, new ArrayList<>(set), i + 1, nums);
            set.remove(set.size() - 1);
            i++;
            while (i < nums.length && nums[i - 1] == nums[i])
                i++;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> results = sol.subsetsWithDup(nums);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
