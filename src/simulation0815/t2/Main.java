package simulation0815.t2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] array1 = new int[n];
            int[] array2 = new int[n];
            for (int i = 0; i < n; i++) {
                array1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                array2[i] = sc.nextInt();
            }
            int[] result = getMaxModeNum(array1, array2, n, m);
            for (int i = 0; i < n - 1; i++) {
                System.out.printf(result[i] + " ");
            }
            System.out.println(result[n - 1]);
        }
    }

    private static int[] getMaxModeNum(int[] array1, int[] array2, int n, int m) {
        int[] result = new int[n];
        int[] copy = new int[m];
        for (int i = 0; i < n; i++) {
            copy[array2[i]]++;
        }
        int k = 0;
        boolean[] flag = new boolean[n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (flag[j]) {
                    continue;
                }
                int num = (i + m - array1[j]) % m;
                if (copy[num] > 0) {
                    flag[j] = true;
                    copy[num]--;
                    result[k++] = i;
                }
                if (k == n) {
                    break;
                }
            }
        }

        return result;
    }
}
