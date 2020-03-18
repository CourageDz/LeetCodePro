package alg55;

public class Solution2 {
    //Memory Limit Exceeded
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= nums[i] && i + j < n; j++) {
                dp[i][i + j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 3; j <= n - i; j++) {
                int k = i + j - 1;
                for (int l = i; l < k; l++) {
                    if (dp[i][l] && dp[l][k])
                        dp[i][k] = true;
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {0};
        Solution2 sol = new Solution2();
        System.out.println(sol.canJump(nums));
    }
}
