package shangtang.t2;

import java.util.Scanner;

public class Main {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] apples = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                apples[i] = sc.nextInt();
                sum += apples[i];
            }
            int result = getFangAnOfApples(apples, n, sum);
            System.out.println(result);
        }
    }

    private static int getFangAnOfApples(int[] apples, int n, int sum) {
        count = 0;
        int leftCount = 0, rightCount = 0;
        int leftMin = Integer.MAX_VALUE;
        dfs(apples, 0, n, leftCount, rightCount, leftMin, sum);
        return count;
    }

    private static void dfs(int[] apples, int i, int n, int leftCount, int rightCount, int leftMin, int rest) {
        if (i == n) {
            if (leftCount > rightCount && leftCount - leftMin < rightCount) {
                count++;
            }
            return;
        }
        leftCount += apples[i];
        rest -= apples[i];
        if (leftMin >= apples[i]) {
            if (leftCount + rest > rightCount) {
                dfs(apples, i + 1, n, leftCount, rightCount, apples[i], rest);
            }
        } else {
            if (leftCount + rest > rightCount) {
                dfs(apples, i + 1, n, leftCount, rightCount, leftMin, rest);
            }
        }
        leftCount -= apples[i];
        rightCount += apples[i];
        if (leftCount + rest > rightCount) {
            dfs(apples, i + 1, n, leftCount, rightCount, leftMin, rest);
        }
    }
}
