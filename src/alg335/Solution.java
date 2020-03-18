package alg335;

public class Solution {
    public boolean isSelfCrossing(int[] x) {
        int n = x.length;
        if (n <= 3)
            return false;
        for (int i = 3; i < n; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                return true;
            }
            if (x[i] == x[i - 2] && i + 1 < n && x[i + 1] + x[i - 3] >= x[i - 1])
                return true;
            if (i + 2 < n && x[i] > x[i - 2] && x[i + 1] + x[i - 3] >= x[i - 1] && x[i + 1] < x[i - 1] && x[i + 2] + x[i - 2] >= x[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] x = {1, 1, 2, 2, 3, 3, 4, 4, 10, 4, 4, 3, 3, 2, 2, 1, 1};
        boolean reuslt = sol.isSelfCrossing(x);
        System.out.println(reuslt);
    }
}
