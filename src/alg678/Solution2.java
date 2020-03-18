package alg678;

import java.util.Arrays;

public class Solution2 {
    public boolean checkValidString1(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        if (n == 0) return true;
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], false);
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*')
                dp[i][i] = true;
            if (i < n - 1 && (s.charAt(i) == '(' || s.charAt(i) == '*') && (s.charAt(i + 1) == '*' || s.charAt(i + 1) == ')'))
                dp[i][i + 1] = true;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (s.charAt(j) == '*' && dp[j + 1][i + j])
                    dp[j][i + j] = true;
                else if (s.charAt(j) == '(' || s.charAt(j) == '*') {
                    for (int k = j + 1; k <= i + j; k++) {
                        if ((s.charAt(k) == ')' || s.charAt(k) == '*') && (k == j + 1 || dp[j + 1][k - 1]) && (k == i + j || dp[k + 1][i + j]))
                            dp[j][i + j] = true;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        String S = "(***)";
        boolean result = sol.checkValidString(S);
        System.out.println(result);
    }
}
