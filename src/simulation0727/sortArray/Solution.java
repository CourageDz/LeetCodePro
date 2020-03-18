package simulation0727.sortArray;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] items = sc.nextLine().split(" ");
            int[] array = new int[items.length];
            for (int i = 0; i < items.length; i++) {
                array[i] = Integer.parseInt(items[i]);
            }
            System.out.println(getMinCost(array));
        }
    }

    private static int getMinCost(int[] array) {
        int n = array.length;
        int[] dp = new int[n + 1];

        dp[0] = Math.min(array[0], array[1]);
        for (int i = 1; i <= array.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2] + array[i]) + array[i - 1];
        }
        return dp[n - 1] < dp[n - 2] ? dp[n - 1] : dp[n - 2];
    }

}
