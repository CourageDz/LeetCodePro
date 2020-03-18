package mFields;

public class Solution {
    public int MaxSum(int m, int n, int[] a) {
        if (n < m || m < 1)
            return 0;
        int[][] b = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            b[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            b[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n - m + i; j++) {
                if (j > i) {
                    b[i][j] = b[i][j - 1] + a[j - 1];
                    for (int k = 0; k < j; k++) {
                        if (b[i][j] < b[i - 1][k] + a[j - 1])
                            b[i][j] = b[i - 1][k] + a[j - 1];
                    }
                } else
                    b[i][j] = b[i - 1][j - 1] + a[j - 1];
            }
        }
        int sum = 0;
        for (int i = m; i <= n; i++) {
            if (sum < b[m][i])
                sum = b[m][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int a[] = {-2, 11, -4, 2, 14, -2};
        Solution sol = new Solution();
        int result = sol.MaxSum(2, 6, a);
        System.out.println(result);
    }
}
