package alg718;

public class Solution {
    public int findLength2(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[] dp = new int[m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (A[i - 1] == B[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int A[] = {1, 2, 3, 2, 1};
        int B[] = {3, 2, 1, 4, 7};
        int result = sol.findLength(A, B);
        System.out.println(result);
    }
}
