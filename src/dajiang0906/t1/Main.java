package dajiang0906.t1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int cases = sc.nextInt();
            for (int i = 0; i < cases; i++) {
                int num = sc.nextInt();
                int time = sc.nextInt();
                int[] ai = new int[num];
                int[] bi = new int[num];
                for (int j = 0; j < num; j++) {
                    ai[j] = sc.nextInt();
                    bi[j] = sc.nextInt();

                }
                int result = getMaxGrades(ai, bi, time);
                System.out.println(result);
            }
        }
    }

    private static int getMaxGrades(int[] ai, int[] bi, int time) {
        int n = ai.length;
        int[][] dp = new int[n + 1][time + 1];
        for (int i = bi[0]; i <= time; i++) {
            dp[1][i] = ai[0];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= time; j++) {
                if (j >= bi[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - bi[i - 1]] + ai[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][time];
    }
}
