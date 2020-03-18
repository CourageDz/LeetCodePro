package alg2017.topic4;

import java.util.Arrays;
import java.util.Scanner;

/***
 * 牛牛和 15 个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，每个位置有一个价值。分割田地的方法是横竖各切三刀，分成 16 份，作为领导干部，牛牛总是会选择其中总价值最小的一份田地， 作为牛牛最好的朋友，你希望牛牛取得的田地的价值和尽可能大，你知道这个值最大可以是多少吗？
 * 输入描述:每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 75），表示田地的大小，接下来的 n 行，每行包含 m 个 0-9 之间的数字，表示每块位置的价值。
 * 输出描述:  输出一行表示牛牛所能取得的最大的价值。
 * 示例1
 * 输入
 * 4 4
 * 3332
 * 3233
 * 3332
 * 2323
 * 输出
 * 2
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int result = getMaxWorthyLand(map);
            System.out.println(result);
        }
    }

    private static int getMaxWorthyLand(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        int[][] sumMap = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(sumMap[i], 0);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sumMap[i][j] = sumMap[i - 1][j] + sumMap[i][j - 1] - sumMap[i - 1][j - 1] + map[i - 1][j - 1];
            }
        }
        int l = 0;
        int max = sumMap[n][m];
        int mid = 0, ans = 0;
        while (l <= max) {
            mid = (l + max) / 2;
            if (isValid(mid, sumMap, n, m)) {
                l = mid + 1;
                ans = mid;
            } else {
                max = mid - 1;
            }
        }
        return ans;
    }

    private static int calc(int x1, int y1, int x2, int y2, int[][] sumMap) {
        return sumMap[x2][y2] - sumMap[x2][y1] - sumMap[x1][y2] + sumMap[x1][y1];
    }

    private static boolean isValid(int value, int[][] sumMap, int n, int m) {

        for (int i = 1; i <= n - 3; i++) {
            for (int j = i + 1; j <= n - 2; j++) {
                for (int k = j + 1; k <= n - 1; k++) {
                    int count = 0;
                    int tempY = 0;
                    for (int l = 1; l <= m; l++) {
                        if (calc(0, tempY, i, l, sumMap) >= value && calc(i, tempY, j, l, sumMap) >= value && calc(j, tempY, k, l, sumMap) >= k && calc(k, tempY, n, l, sumMap) >= value) {
                            count++;
                            tempY = l;
                        }
                    }
                    if (count >= 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
