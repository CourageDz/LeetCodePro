package alg188;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    //199 / 211 test cases passed.
    public int maxProfitFailed(int k, int[] prices) {
        if (prices.length == 0 || k == 0)
            return 0;
        Queue<Integer> profits = new PriorityQueue<>(k);
        int n = prices.length;
        int i = 0;
        while (i != n - 1) {
            int buy = prices[i];
            while (i + 1 < n && prices[++i] <= buy)
                buy = prices[i];
            int sell = prices[i];
            while (i + 1 < n && prices[++i] >= sell)
                sell = prices[i];
            int profit = sell - buy;
            if (profits.size() < k)
                profits.offer(profit);
            else {
                int minPro = profits.peek();
                if (profit > minPro) {
                    profits.poll();
                    profits.offer(profit);
                }
            }
        }
        int maxPro = 0;
        while (!profits.isEmpty()) {
            maxPro += profits.poll();
        }
        return maxPro;
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2)
            return quickSolve(prices);
        int dp[][] = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], tmpMax + prices[j]);
                tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }


    private int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int prices[] = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        int result = sol.maxProfit(2, prices);
        System.out.println(result);
    }
}
