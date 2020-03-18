package test0717;

import java.util.Scanner;

/***
 * 链接：https://www.nowcoder.com/questionTerminal/2f050f7a6ea7439a84f294f0e16f53a3?source=relative&tdsourcetag=s_pctim_aiomsg
 * 来源：牛客网
 *
 * 牛牛在农场饲养了n只奶牛,依次编号为0到n-1, 牛牛的好朋友羊羊帮牛牛照看着农场.有一天羊羊看到农场中逃走了k只奶牛,但是他只会告诉牛牛逃走的k只奶牛的编号之和能被n整除。
 * 你现在需要帮牛牛计算有多少种不同的逃走的奶牛群。因为结果可能很大,输出结果对1,000,000,007取模。
 * 例如n = 7 k = 4:
 * 7只奶牛依次编号为0到6, 逃走了4只
 * 编号和为7的有:{0, 1, 2, 4}
 * 编号和为14的有:{0, 3, 5, 6}, {1, 2, 5, 6}, {1, 3, 4, 6},{2, 3, 4, 5}
 * 4只牛的编号和不会大于18,所以输出5.
 *
 * 输入描述:
 * 输入包括一行,两个整数n和k(1 ≤ n ≤ 1000),(1 ≤ k ≤ 50),以空格分割。
 *
 * 输出描述:
 * 输出一个整数表示题设所求的种数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(getCountOfMilk(n, k));
        }
    }

    private static int getCountOfMilk(int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int t = k; t >= 1; t--) {
                for (int j = 0; j < n; j++) {
                    dp[t][j] = (dp[t][j] + dp[t - 1][(j + n - i) % n]) % 1000000007;
                }
            }
        }
        return dp[k][0];
    }


}
