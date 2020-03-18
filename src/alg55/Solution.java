package alg55;

public class Solution {
    //Time exceeded
    boolean[] isVisit = null;

    public boolean canJump(int[] nums) {
        isVisit = new boolean[nums.length + 1];
        return dfs(nums, 1, nums.length);
    }

    public boolean dfs(int[] nums, int i, int n) {
        if (i >= n)
            return true;
        if (!isVisit[i]) {
            isVisit[i] = true;
            for (int j = 1; j <= nums[i - 1]; j++) {
                if (dfs(nums, i + j, n))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 0};
        Solution sol = new Solution();
        System.out.println(sol.canJump(nums));
    }
}
