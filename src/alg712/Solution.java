package alg712;

public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        long max = 0;
        long count1 = 0;
        long count2 = 0;
        for (int i = 0; i < m; i++) {
            count1 += s1.charAt(i);
            dp[i][0] = 0;
        }
        dp[m][0] = 0;
        for (int i = 0; i < n; i++) {
            count2 += s2.charAt(i);
            dp[0][i] = 0;
        }
        dp[0][n] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + s1.charAt(i);
                    if (dp[i + 1][j + 1] > max)
                        max = dp[i + 1][j + 1];
                } else if (dp[i + 1][j] >= dp[i][j + 1]) {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return (int) (count1 + count2 - max * 2);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "sea";
        String s2 = "eat";
        int result = sol.minimumDeleteSum(s1, s2);
        System.out.println(result);
    }
}
