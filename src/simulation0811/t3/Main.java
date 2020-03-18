package simulation0811.t3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String sk = sc.next();
            int k = Integer.parseInt(sk);
            for (int i = 0; i < k; i++) {
                String s = sc.next();
                int num = getMaxSerialNChars(s.toCharArray());
                System.out.println(num);
            }
        }
    }

    private static int getMaxSerialNChars(char[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;
        int[][] dp = new int[n + 1][3];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            if (array[i - 1] == 'N') {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (array[i - 1] != 'N') {
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][1] = dp[i - 1][1] + 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (array[i - 1] != 'N') {
                dp[i][2] = dp[i - 1][1] + 1;
            } else {
                dp[i][2] = dp[i - 1][2] + 1;
            }

        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i][2] > max) {
                max = dp[n][2];
            }
        }
        return max;
    }
}
