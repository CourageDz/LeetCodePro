package alg279;

public class Solution {
    private int count = 0;

    public int numSquares(int n) {
        dfs(n);
        return count;
    }

    public void dfs(int x) {
        int degree = (int) Math.floor(Math.sqrt(x));
        int rest = x - (int) Math.pow(degree, 2);
        if (rest == 0) {
            count++;
            return;
        } else {
            count++;
            dfs(rest);
        }
    }

    public static void main(String[] args) {
        long x = Long.MAX_VALUE;
        Solution sol = new Solution();
        int n = 12;
        sol.numSquares(n);
        System.out.println(sol.count);
    }
}
