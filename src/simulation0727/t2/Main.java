package simulation0727.t2;

import java.util.Scanner;

public class Main {
    private static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            count = 0;
            int target = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            System.out.println(getNumOfSumN(array, n, target));
        }
    }

    private static int getNumOfSumN(int[] array, int n, int target) {
        if (array == null || n <= 0)
            return 0;
        dfs(array, 0, n, target, 0);
        return count;
    }

    private static void dfs(int[] array, int i, int n, int target, int sum) {
        if (i == n) {
            if (target == sum) {
                count++;
            }
            return;
        }
        if (sum + array[i] <= target) {
            dfs(array, i + 1, n, target, sum + array[i]);
        }
        dfs(array, i + 1, n, target, sum);
    }
}
